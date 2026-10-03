import java.util.Scanner;
abstract class Ticket {
    int count;
    public static final double CONVENIENCE_FEE = 20.0; // Written in one place[cite: 10]
    public Ticket(int count) {
        this.count = count;
    }
    public abstract double getBasePricePerTicket();
    public abstract String getSeatName();

    public double getTotalAmount() {
        return count * (getBasePricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 150.0; }[cite: 10]
    @Override public String getSeatName() { return "REGULAR"; }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 250.0; }[cite: 10]
    @Override public String getSeatName() { return "PREMIUM"; }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 400.0; }[cite: 10]
    @Override public String getSeatName() { return "RECLINER"; }
}
public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Ticket[] bookings = new Ticket[n];
        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            if (seat.equalsIgnoreCase("REGULAR")) {
                bookings[i] = new RegularTicket(count);
            } else if (seat.equalsIgnoreCase("PREMIUM")) {
                bookings[i] = new PremiumTicket(count);
            } else if (seat.equalsIgnoreCase("RECLINER")) {
                bookings[i] = new ReclinerTicket(count);
            }
        }
        double total = 0;
        for (Ticket t : bookings) {
            double amt = t.getTotalAmount();
            total += amt;
            System.out.printf("%s: %.2f\n", t.getSeatName(), amt);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
