import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Payment {
    
    public static double calculatePayment(LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        final double initialRate = 3.0;
        final double hourlyRate = 2.5;
        //long durationInMinutes = ChronoUnit.MINUTES.between(checkInTime, checkOutTime);
        long durationInMinutes = ChronoUnit.SECONDS.between(checkInTime, checkOutTime);
        double fee;

        if (durationInMinutes <= 30) {
            fee = initialRate;
        } else {
            double remainingMinutes = durationInMinutes - 30;
            fee = initialRate + Math.ceil(remainingMinutes / 30.0) * hourlyRate;
        }
        return fee;
    }

    public static double calculateAdditionalCharges(LocalDateTime plannedCheckOutTime, LocalDateTime actualCheckOutTime) {
        final double initialLateCharge = 5.0;
        final double hourlyLateCharge = 10.0;
        //long additionalDurationInMinutes = ChronoUnit.MINUTES.between(plannedCheckOutTime, actualCheckOutTime);
        long additionalDurationInMinutes = ChronoUnit.SECONDS.between(plannedCheckOutTime, actualCheckOutTime);
        double fee;

        if (additionalDurationInMinutes <= 0) {
            return 0.0;
        } else if (additionalDurationInMinutes <= 60) {
            fee = initialLateCharge;
        } else {
            fee = initialLateCharge + Math.floor(additionalDurationInMinutes / 60.0) * hourlyLateCharge;
        }
        return fee;
    }
}

