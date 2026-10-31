public class WarehouseBinGridScan {
    public static void warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")");
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        warehouseSummary(grid);
    }
}
