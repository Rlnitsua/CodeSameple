package rlnitsua.contest;

public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int max = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int h = 2;
                while (i + h <= grid.length && j + h <= grid[0].length) {
                    if (isMagic(grid, i, j, h)) {
                        max = Math.max(max, h);
                    }
                    h++;
                }
            }
        }

        return max;
    }

    private boolean isMagic(int[][] grid, int startRow, int startColumn, int h) {
        int sum = 0;
        for (int i = startColumn; i < startColumn + h; i++) {
            sum += grid[startRow][i];
        }

        for (int i = startRow; i < startRow + h; i++) {
            int lineSum = 0;
            for (int j = startColumn; j < startColumn + h; j++) {
                lineSum += grid[i][j];
            }
            if (lineSum != sum) {
                return false;
            }
        }

        for (int j = startColumn; j < startColumn + h; j++) {
            int columnSum = 0;
            for (int i = startRow; i < startRow + h; i++) {
                columnSum += grid[i][j];
            }
            if (columnSum != sum) {
                return false;
            }
        }

        int sum0 = 0;
        int sum0Row = startRow;
        int sum0Column = startColumn;
        while (sum0Row < startRow + h && sum0Column < startColumn + h) {
            sum0 += grid[sum0Row][sum0Column];
            sum0Row++;
            sum0Column++;
        }

        int sum1 = 0;
        int sum1Row = startRow;
        int sum1Column = startColumn + h - 1;
        while (sum1Row < startRow + h && sum1Column >= startColumn) {
            sum1 += grid[sum1Row][sum1Column];
            sum1Row++;
            sum1Column--;
        }

        return sum == sum0 && sum == sum1;
    }
}
