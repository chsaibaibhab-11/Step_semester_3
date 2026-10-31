import java.util.Scanner;
import java.util.ArrayList;
public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] input = inputLine.replaceAll("[\\[\\]]", "").split(", ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : input) {
            list.add(Integer.parseInt(s.trim()));
        }
        int even = 0;
        int odd = 0;

        for (int num : list) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        scanner.close();
    }
}
