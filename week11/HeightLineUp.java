import java.util.Arrays;
public class HeightLineUp {
    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);
    }
    public static void lineUp(int[] heights) {
        boolean swapped;
        int pass = 1;
        do {
            swapped = false;
            for (int i = 0; i < heights.length - pass; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }
            for (int i = 0; i < heights.length - 1; i++) {
                 if (heights[i] > heights[i + 1] && !swapped) {
                     swapped = true;
                     break;
                 }
            }
            swapped = false;
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;
        } while (swapped);
    }
}
