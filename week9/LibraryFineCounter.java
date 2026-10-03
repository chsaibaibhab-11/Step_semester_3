import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;
    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    public abstract double calculateFine();
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() { return daysLate * 2.0; } // 2 per day[cite: 3]
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0); // 5 per day up to 50 max[cite: 3]
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() { return daysLate * 1.0; } // 1 per day[cite: 3]
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int days = scanner.nextInt();
            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new Book(title, days);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new DVD(title, days);
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items[i] = new Magazine(title, days);
            }
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f\n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}
