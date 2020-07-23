package lizbyu.array;

public class MaxIncreasetoKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = calculateRowMax(grid);
        int[] columnMax = calculateColumnMax(grid);

        int res = 0;
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                res += Math.min(rowMax[i], columnMax[j]) - grid[i][j];
            }
        }
        return res;
    }

    private int[] calculateRowMax(int[][] grid) {
        int[] rowMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }
        return rowMax;
    }

    private int[] calculateColumnMax(int[][] grid) {
        int[] columnMax = new int[grid.length];
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                columnMax[j] = Math.max(columnMax[j], grid[i][j]);
            }
        }
        return columnMax;
    }
}
