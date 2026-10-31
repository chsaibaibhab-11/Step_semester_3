import java.util.Arrays;
public class DiceThrowTally {
    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int i = 0; i < rolls.length; i++) {
            count[rolls[i]]++;
        }
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + (i < 6 ? " " : ""));
        }
        System.out.println();

        int index = 0;
        for (int i = 1; i <= 6; i++) {
            while (count[i] > 0) {
                rolls[index++] = i;
                count[i]--;
            }
        }

        return rolls;
    }
}
