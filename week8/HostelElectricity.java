import java.util.Scanner;
public class HostelElectricity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            double bill = 0;

            if (type.equals("SINGLE")) {
                bill = units * 8.0;
            } else if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                bill = (units * 6.0) / occupants;
            } else if (type.equals("AC")) {
                bill = (units * 10.0) + 200.0;
            }

            grandTotal += bill;
            System.out.printf("%s: %.2f\n", type, bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
