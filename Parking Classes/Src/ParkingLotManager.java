import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class ParkingLotManager {
    private final Connection CONNECTION; 
    private final String INSERT_STMT;
    private final String GET_CHECKOUT_TIME_STMNT;
    private final String GET_SPOT_ID_STMT;
    private final String SET_SPOT_EMPTY_STMT;

    public ParkingLotManager() throws SQLException{ 
        CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/ParkingLotDB", "testuser", "pass");
        INSERT_STMT = "INSERT INTO ParkingLot (ticketId, spotID, isOccupied, vehiclePlate, checkInTime, checkOutTime, actualCheckOutTime) VALUES (?, ?, ?, ?, ?, ?, NULL);";
        GET_CHECKOUT_TIME_STMNT = "SELECT checkOutTime FROM ParkingLot WHERE ticketId = ?";
        GET_SPOT_ID_STMT = "SELECT spotID FROM ParkingLot WHERE ticketId = ?";
        SET_SPOT_EMPTY_STMT = "UPDATE ParkingLot SET isOccupied = false, actualCheckOutTime = ? WHERE ticketId = ?";
    }

    // this could be changed to return void
    public Ticket parkVehicle(String spotId, String licencePlate, double durationInHours) throws SQLException {
        // Create a new ticket for customer
        LocalDateTime checkInTime = LocalDateTime.now();
        Ticket ticket = new Ticket(spotId, licencePlate, checkInTime, durationInHours);
        try {
            PrintWriter writer = new PrintWriter("./bin/currentTicket.txt");
            writer.println(ticket);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while trying to write to /bin/currentTicket.txt");
            e.printStackTrace();
        }
        try { // Send some ticket info to database
            PreparedStatement outStmnt = this.CONNECTION.prepareStatement(this.INSERT_STMT);
            //LocalDateTime checkOutTime = checkInTime.plusHours((long) durationInHours);
            LocalDateTime checkOutTime = checkInTime.plusSeconds((long)(60*durationInHours));
            outStmnt.setInt(1, ticket.getTicketId());
            outStmnt.setString(2, spotId);
            outStmnt.setBoolean(3, true);
            outStmnt.setString(4, licencePlate);
            outStmnt.setTimestamp(5, Timestamp.valueOf(checkInTime));
            outStmnt.setTimestamp(6, Timestamp.valueOf(checkOutTime));
             
            outStmnt.executeUpdate();
            return ticket;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public LocalDateTime getCheckOutTimeFromDB(int ticketId) throws SQLException {
        try (PreparedStatement stmt = CONNECTION.prepareStatement(GET_CHECKOUT_TIME_STMNT)) {
            stmt.setInt(1, ticketId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getTimestamp("checkOutTime").toLocalDateTime();
                } else {
                    throw new SQLException("No record found for ticketId: " + ticketId);
                }
            }
        }
    } 
    public String getSpotIdFromDB(int ticketId) throws SQLException {
        try (PreparedStatement stmt = CONNECTION.prepareStatement(GET_SPOT_ID_STMT)) {
            stmt.setInt(1, ticketId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("spotID");
                } else {
                    throw new SQLException("No record found for ticketId: " + ticketId);
                }
            }
        }
    }
    public void setSpotAsEmpty(int ticketId, LocalDateTime actualCheckOutTime) throws SQLException {
        try (PreparedStatement stmt = CONNECTION.prepareStatement(SET_SPOT_EMPTY_STMT)) {
            stmt.setTimestamp(1, Timestamp.valueOf(actualCheckOutTime));
            stmt.setInt(2, ticketId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating spot status and checkout time failed, no rows affected for ticketId: " + ticketId);
            }
        }
    }

    
    public void initializeLot() throws SQLException {
        final String GET_HIGHEST_TICKET_ID = "SELECT MAX(ticketId) AS highestTicketId FROM ParkingLot";
        try (PreparedStatement stmt = CONNECTION.prepareStatement(GET_HIGHEST_TICKET_ID)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int highestTicketId = rs.getInt("highestTicketId");
                if (rs.wasNull()) {
                    Ticket.setTicketIdCounter(999);
                } else {
                    Ticket.setTicketIdCounter(highestTicketId);
                }
            }
        }
        final String GET_OCCUPIED_SPOT_IDS = "SELECT spotID FROM ParkingLot WHERE isOccupied = true";
        try (PreparedStatement stmt = CONNECTION.prepareStatement(GET_OCCUPIED_SPOT_IDS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String spotId = rs.getString("spotID");
                App.markButtonAsPurchased(spotId);
            }
        }
    }
}

