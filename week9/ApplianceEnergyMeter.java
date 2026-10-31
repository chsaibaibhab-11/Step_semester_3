import java.util.Scanner;

interface SaverModeable {
    boolean supportsSaver();
}

abstract class Appliance {
    String name;
    double powerWatts;
    double hours;
    boolean requestedSaver;

    public Appliance(String name, double powerWatts, double hours, boolean requestedSaver) {
        this.name = name;
        this.powerWatts = powerWatts;
        this.hours = hours;
        this.requestedSaver = requestedSaver;
    }

    public double calculateUnits() {
        double units = (powerWatts * hours) / 1000.0;[cite: 13]
        if (requestedSaver) {
            units = units * 0.75; // Reduced by 25%[cite: 13]
        }
        return units;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0; // Cost = units * 8[cite: 13]
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean requestedSaver) {
        super("FRIDGE", 150.0, hours, requestedSaver); //[cite: 13]
    }
}

class AirConditioner extends Appliance implements SaverModeable {
    public AirConditioner(double hours, boolean requestedSaver) {
        super("AC", 1500.0, hours, requestedSaver); //[cite: 13]
    }
    @Override public boolean supportsSaver() { return true; }
}

class Television extends Appliance {
    public Television(double hours, boolean requestedSaver) {
        super("TV", 100.0, hours, requestedSaver); //[cite: 13]
    }
}

class WashingMachine extends Appliance implements SaverModeable {
    public WashingMachine(double hours, boolean requestedSaver) {
        super("WASHER", 500.0, hours, requestedSaver); //[cite: 13]
    }
    @Override public boolean supportsSaver() { return true; }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double hours = scanner.nextDouble();
            boolean hasSaver = false;

            if (scanner.hasNext("(?i)SAVER")) {
                scanner.next();
                hasSaver = true;
            }

            Appliance app = null;
            if (type.equalsIgnoreCase("FRIDGE")) {
                app = new Fridge(hours, hasSaver);
            } else if (type.equalsIgnoreCase("AC")) {
                app = new AirConditioner(hours, hasSaver);
            } else if (type.equalsIgnoreCase("TV")) {
                app = new Television(hours, hasSaver);
            } else if (type.equalsIgnoreCase("WASHER")) {
                app = new WashingMachine(hours, hasSaver);
            }

            if (hasSaver && !(app instanceof SaverModeable)) {
                System.out.println(app.name + ": saver mode not supported");[cite: 13]
                continue;
            }

            double units = app.calculateUnits();
            double cost = app.calculateCost();
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.name, units, cost);
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}
