class PayrollAccount {

    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary) {

        if (basicSalary < 0) {
            System.out.println("Negative salary not allowed");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println("Bonus rejected");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }
    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }
    double getNetSalary() {
        return basicSalary + bonus;
    }
}
public class PayrollAccountDemo {
    public static void main(String[] args) {
        PayrollAccount employee = new PayrollAccount(50000);
        employee.creditBonus(5000);
        employee.deductTax(10);
        System.out.println("Net salary: Rs " + employee.getNetSalary());
    }
}
