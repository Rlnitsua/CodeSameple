package rlnitsua.contest;

public class RotateGrid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int startRow = 0;
        int startColumn = 0;
        int endRow = grid.length - 1;
        int endColumn = grid[0].length - 1;

        while (startRow < endRow && startColumn < endColumn) {
            doCircle(grid, startRow++, startColumn++, endRow--, endColumn--, k);
        }
        return grid;
    }

    private void doCircle(int[][] grid, int startRow, int startColumn, int endRow, int endColumn, int k) {
        int width = endColumn - startColumn + 1;
        int length = endRow - startRow + 1;
        int sum = (2 * width) + 2 * (length - 2);
        int count = k % sum;

        while (count != 0) {
            int temp = grid[startRow][startColumn];
            for (int j = startColumn; j < endColumn; j++) {
                grid[startRow][j] = grid[startRow][j + 1];
            }
            for (int i = startRow; i < endRow; i++) {
                grid[i][endColumn] = grid[i + 1][endColumn];
            }
            for (int j = endColumn; j > startColumn; j--) {
                grid[endRow][j] = grid[endRow][j - 1];
            }
            for (int i = endRow; i > startRow; i--) {
                grid[i][startColumn] = grid[i - 1][startColumn];
            }
            grid[startRow + 1][startColumn] = temp;
            count--;
        }
    }
}
