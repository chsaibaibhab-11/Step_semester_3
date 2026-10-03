import java.util.Scanner;

interface NightServiceable {
    boolean supportsNightService();
}

abstract class Cab {
    double distance;
    String time;
    String cabName;
    public static final double MIN_FARE = 100.0; // Minimum fare rule[cite: 12]

    public Cab(String cabName, double distance, String time) {
        this.cabName = cabName;
        this.distance = distance;
        this.time = time;
    }

    public abstract double getRatePerKm();
}

class MiniCab extends Cab {
    public MiniCab(double distance, String time) { super("MINI", distance, time); }
    @Override public double getRatePerKm() { return 10.0; } //[cite: 12]
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double distance, String time) { super("SEDAN", distance, time); }
    @Override public double getRatePerKm() { return 14.0; } //[cite: 12]
    @Override public boolean supportsNightService() { return true; }
}

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double distance, String time) { super("SUV", distance, time); }
    @Override public double getRatePerKm() { return 18.0; } //
    @Override public boolean supportsNightService() { return true; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;
            if (cabType.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km, time);
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km, time);
            } else if (cabType.equalsIgnoreCase("SUV")) {
                cab = new SuvCab(km, time);
            }

            if (time.equalsIgnoreCase("NIGHT")) {
                if (!(cab instanceof NightServiceable)) {
                    System.out.println(cab.cabName + ": night service not available");[cite: 13]
                    continue;
                }
            }

            double baseFare = cab.distance * cab.getRatePerKm();
            double fare = Math.max(baseFare, Cab.MIN_FARE);

            if (time.equalsIgnoreCase("NIGHT")) {
                fare = fare * 1.20; // 20% extra for night service[cite: 13]
            }

            total += fare;
            System.out.printf("%s: %.2f\n", cab.cabName, fare);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
