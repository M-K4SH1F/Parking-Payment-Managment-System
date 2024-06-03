import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String spotId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private double durationInHours;
    private double amountPaid;
    private static int ticketIdCounter;
    private int ticketId;

    private String licencePlate;

    public Ticket(String spotId, String licencePlate, LocalDateTime checkInTime, double durationInHours) {
        this.spotId = spotId;
        this.licencePlate = licencePlate;
        this.checkInTime = checkInTime;
        //this.checkOutTime = checkInTime.plusMinutes((long)(60*durationInHours));
        this.checkOutTime = checkInTime.plusSeconds((long)(60*durationInHours));
        this.amountPaid = Payment.calculatePayment(checkInTime, checkOutTime);
        this.durationInHours = durationInHours;
        this.ticketId = ++ticketIdCounter;
    }

    public int getTicketId() {
        return ticketId;
    }

    public static void setTicketIdCounter(int counter) {
        ticketIdCounter = counter;
    }

    @Override
    public String toString() {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "------------------------- PARKING RECEIPT -----------------------" 
             + "\n Ticket ID: " + ticketId
             + "\n Parking Spot: " + spotId
             + "\n Licence Plate: " + licencePlate
             + "\n Check-In Time: " + checkInTime.format(formatter)
             + "\n Check-Out Time: " + checkOutTime.format(formatter)
             + "\n Duration: " + (durationInHours <= 0.5 ? "30 minutes" : durationInHours + (durationInHours == 1 ? " hour" : " hours"))
             + "\n Parking Rate: " + (durationInHours <= 0.5 ? "$3 for 30 minutes" : "$5 per hour + initial $3 for 30 minutes")
             + "\n Total Amount Paid: $" + String.format("%.2f", amountPaid)
             + "\n-----------------------------------------------------------------"
             + "\n Thank you for using our Parking Payment System. Have a nice day! "
             + "\n-----------------------------------------------------------------\n"
            ;
    }
}
