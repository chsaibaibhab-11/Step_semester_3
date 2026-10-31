import java.time.LocalDate;
import java.util.Scanner;
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");

            int days = 0;
            if (type.equals("BOOK")) {
                days = 14;
            } else if (type.equals("DVD")) {
                days = 7;
            } else if (type.equals("MAGAZINE")) {
                days = 3;
            }

            LocalDate dueDate = currentDate.plusDays(days);
            System.out.println(title + ": " + dueDate);
        }
    }
}
