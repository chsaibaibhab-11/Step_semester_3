import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        StringBuilder sb = new StringBuilder(word);
        String reversedWord = sb.reverse().toString();

        System.out.println(reversedWord);

        if (word.equals(reversedWord)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }
        scanner.close();
    }
}
