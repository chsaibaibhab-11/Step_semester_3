import java.util.Scanner;

public class TransportFare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            double fare = 0;
            if (type.equals("BUS")) {
                fare = 2.0 + (0.10 * distance);
                if (fare > 10.0) {
                    fare = 10.0;
                }
            } else if (type.equals("TRAIN")) {
                fare = 3.0 + (0.15 * distance);
            } else if (type.equals("METRO")) {
                double peakFactor = scanner.nextDouble();
                fare = (1.50 + (0.20 * distance)) * peakFactor;
            }

            grandTotal += fare;
            System.out.printf("%s: %.2f\n", type, fare);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
