import java.util.Scanner;
public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            double fee = 0;
            if (type.equals("CARD")) {
                fee = amount * 0.02;
            } else if (type.equals("WALLET")) {
                fee = amount * 0.01;
            } else if (type.equals("BANKTRANSFER")) {
                fee = 0;
            }
            double adjusted = amount + fee;
            total += adjusted;
            System.out.printf("%s: %.2f\n", type, adjusted);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
