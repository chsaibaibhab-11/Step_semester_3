import java.util.Scanner;

abstract class Staff {
    String name;
    public Staff(String name) {
        this.name = name;
    }
    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }
    @Override
    public double calculatePay() {
        return weeklySalary; // Paid fixed weekly salary[cite: 2]
    }
}

class HourlyStaff extends Staff {
    int hours;
    double rate;
    public HourlyStaff(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5); // Overtime rule[cite: 2]
        }
    }
}

class InternStaff extends Staff {
    double stipend;
    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    @Override
    public double calculatePay() {
        return stipend; // Paid fixed stipend[cite: 2]
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if (type.equalsIgnoreCase("FULLTIME")) {
                staffList[i] = new FullTimeStaff(name, scanner.nextDouble());
            } else if (type.equalsIgnoreCase("HOURLY")) {
                staffList[i] = new HourlyStaff(name, scanner.nextInt(), scanner.nextDouble());
            } else if (type.equalsIgnoreCase("INTERN")) {
                staffList[i] = new InternStaff(name, scanner.nextDouble());
            }
        }
        double totalPayroll = 0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", s.name, pay);
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        scanner.close();
    }
}
