import java.util.Scanner;
public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            double finalAmount = 0;

            if (type.equals("STUDENT")) {
                finalAmount = amount * 0.90;
            } else if (type.equals("STAFF")) {
                finalAmount = amount * 0.95;
            } else if (type.equals("GUEST")) {
                finalAmount = amount + 10.0;
            }
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", type, finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
