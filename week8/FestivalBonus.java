import java.util.Scanner;

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            double bonus = 0;
            if (type.equals("FULLTIME")) {
                bonus = salary * 0.10;
            } else if (type.equals("PARTTIME")) {
                bonus = salary * 0.05;
            } else if (type.equals("INTERN")) {
                bonus = 2000.0;
            }
            grandTotal += bonus;
            System.out.printf("%s: %.2f\n", name, bonus);
        }
        System.out.printf("Total Bonus: %.2f\n", grandTotal);
    }
}
