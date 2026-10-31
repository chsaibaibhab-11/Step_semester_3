import java.util.Scanner;

abstract class Connection {
    int units;
    String typeName;
    public Connection(String typeName, int units) {
        this.typeName = typeName;
        this.units = units;
    }
    public abstract double calculateBill();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) { super("HOME", units); }
    @Override
    public double calculateBill() {
        if (units <= 100) return units * 5.0;
        return (100 * 5.0) + ((units - 100) * 7.0); // 5 for first 100, 7 after[cite: 4]
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) { super("SHOP", units); }
    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0; // 8 per unit + 100 fixed[cite: 4]
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) { super("FACTORY", units); }
    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0); // 6 per unit, min 1000[cite: 4]
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equalsIgnoreCase("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connections[i] = new FactoryConnection(units);
            }
        }

        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f\n", c.typeName, bill);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
