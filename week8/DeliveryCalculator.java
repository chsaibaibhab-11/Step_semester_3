import java.util.Scanner;

public class DeliveryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            double fee = 0;

            if (type.equals("STANDARD")) {
                fee = 5.0 + (0.50 * weight) + (0.10 * distance);
            } else if (type.equals("EXPRESS")) {
                fee = 15.0 + (1.00 * weight) + (0.20 * distance);
            } else if (type.equals("INTERNATIONAL")) {
                double customs = scanner.nextDouble();
                fee = 25.0 + (2.00 * weight) + (0.50 * distance) + customs;
            }
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", type, fee);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
