import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    double weight;
    double declaredValue;
    String typeName;

    public Parcel(String typeName, double weight, double declaredValue) {
        this.typeName = typeName;
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super("STANDARD", weight, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight); // Standard rule
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super("EXPRESS", weight, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weight); // Express rule[cite: 11]
    }
    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue; // 2% insurance[cite: 11]
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super("FRAGILE", weight, declaredValue);
    }
    @Override
    public double calculateCharge() {
        double standardCharge = 40.0 + (10.0 * weight);
        return standardCharge + 50.0; // Standard charge + handling fee[cite: 11]
    }
    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue; // 2% insurance[cite: 11]
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredVal = scanner.nextDouble();
            if (type.equalsIgnoreCase("STANDARD")) {
                parcels[i] = new StandardParcel(weight, declaredVal);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, declaredVal);
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, declaredVal);
            }
        }

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = 0.0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance(p.declaredValue);
            }
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.typeName, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
