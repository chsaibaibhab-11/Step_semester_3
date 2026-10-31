public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int bestRow = -1;
        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentTotal += grid[i][j];
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }

        System.out.println("Row " + bestRow + ", Total " + maxTotal);
    }
    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        busiestRow(grid);
    }
}
