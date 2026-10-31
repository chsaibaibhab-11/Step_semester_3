import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    String name;
    public Student(String name) {
        this.name = name;
    }
    public abstract double getTuitionFee();
}

class DayScholar extends Student implements BusUser {
    public static final double TRANSPORT_FEE = 12000.0; // Transport fee in one place
    public DayScholar(String name) { super(name); }
    @Override
    public double getTuitionFee() { return 40000.0; } //[cite: 12]
    @Override
    public double getTransportFee() { return TRANSPORT_FEE; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override
    public double getTuitionFee() { return 40000.0 + 60000.0; } // Tuition + hostel fee[cite: 12]
}

class ScholarStudent extends Student implements BusUser {
    public static final double TRANSPORT_FEE = 12000.0;
    public ScholarStudent(String name) { super(name); }
    @Override
    public double getTuitionFee() { return 20000.0; } // Half of normal tuition[cite: 12]
    @Override
    public double getTransportFee() { return TRANSPORT_FEE; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String t1 = scanner.next();
            String name = "";
            if (t1.equalsIgnoreCase("DAY")) {
                scanner.next(); // read "SCHOLAR"
                name = scanner.next();
                students[i] = new DayScholar(name);
            } else if (t1.equalsIgnoreCase("HOSTELLER")) {
                name = scanner.next();
                students[i] = new Hosteller(name);
            } else if (t1.equalsIgnoreCase("SCHOLAR")) {
                name = scanner.next();
                students[i] = new ScholarStudent(name);
            }
        }

        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.getTuitionFee();
            if (s instanceof BusUser) {
                fee += ((BusUser) s).getTransportFee();
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.name, fee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}
