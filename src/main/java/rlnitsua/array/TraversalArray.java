package rlnitsua.array;

public class TraversalArray {
    private int index = 0;

    public int[] printMatrix (int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }

        int[] res = new int[matrix.length * matrix[0].length];
        int beginRow = 0;
        int beginColumn = 0;
        int endRow = matrix.length - 1;
        int endColumn = matrix[0].length - 1;

        while (beginRow <= endRow && beginColumn <= endColumn) {
            traversal(matrix, beginRow++, beginColumn++, endRow--, endColumn--, res);
        }

        return res;
    }

    private void traversal(int[][] matrix, int beginRow, int beginColumn, int endRow, int endColumn, int[] res) {
        if (beginRow == endRow) {
            for (int i = beginColumn; i <= endColumn; i++) {
                res[index++] = matrix[beginRow][i];
            }
        } else if (beginColumn == endColumn) {
            for (int i = beginRow; i <= endRow; i++) {
                res[index++] = matrix[i][beginColumn];
            }
        } else {
            int currentRow = beginRow;
            int currentColumn = beginColumn;

            while (currentColumn < endColumn) {
                res[index++] = matrix[currentRow][currentColumn++];
            }
            while (currentRow < endRow) {
                res[index++] = matrix[currentRow++][currentColumn];
            }
            while (currentColumn > beginColumn) {
                res[index++] = matrix[currentRow][currentColumn--];
            }
            while (currentRow > beginRow) {
                res[index++] = matrix[currentRow--][currentColumn];
            }
        }
    }
}
