import java.util.Scanner;

abstract class Booking {
    double distance;
    String modeName;
    public static final double BOOKING_FEE = 50.0; // Booking fee written in one place[cite: 5]

    public Booking(String modeName, double distance) {
        this.modeName = modeName;
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public double getTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distance) { super("BUS", distance); }
    @Override
    public double calculateBaseFare() { return distance * 2.0; } // 2 per km[cite: 5]
}

class TrainBooking extends Booking {
    public TrainBooking(double distance) { super("TRAIN", distance); }
    @Override
    public double calculateBaseFare() { return distance * 1.5; } // 1.5 per km[cite: 5]
}

class FlightBooking extends Booking {
    public FlightBooking(double distance) { super("FLIGHT", distance); }
    @Override
    public double calculateBaseFare() { return 2500.0 + (distance * 4.0); } // 2500 + 4 per km[cite: 5]
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            if (mode.equalsIgnoreCase("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f\n", b.modeName, b.getTotalFare());
        }
        scanner.close();
    }
}
