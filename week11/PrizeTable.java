import java.util.Arrays;
public class PrizeTable {
    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        prizeTable(marks1);

        int[] marks2 = {80, 70, 60};
        prizeTable(marks2);
    }
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        System.out.println(Arrays.toString(marks));
        System.out.println("swaps = " + swaps);
        return swaps;
    }
}
