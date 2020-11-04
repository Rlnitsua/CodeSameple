package rlnitsua.array;

public class ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid) {
        int sum = 0;
        for (int[] column : grid) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid[0].length; j++) {
                sum += column[j] == 0 ? 0 : 1;
                max = Math.max(max, column[j]);
            }
            sum += max;
        }

        for (int j = 0; j < grid[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int[] row : grid) {
                max = Math.max(max, row[j]);
            }
            sum += max;
        }
        return sum;
    }
}
