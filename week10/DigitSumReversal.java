import java.util.Scanner;

public class DigitSumReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        int reverse = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
        scanner.close();
    }
}
