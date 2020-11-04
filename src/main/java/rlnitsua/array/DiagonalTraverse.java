package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

public class DiagonalTraverse {
    private static final String TAG = "DiagonalTraverse";

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        } else if (matrix.length == 0) {
            return new int[0];
        }

        final int MAX_ROW = matrix.length;
        final int MAX_COLUMN = matrix[0].length;

        int[] res = new int[MAX_ROW * MAX_COLUMN];
        int index = 0;

        // sum = sumIndex
        for (int sum = 0; sum < (MAX_ROW + MAX_COLUMN - 1); sum++) {
            // up
            if (sum % 2 == 0) {
                // traverse column
                int startColmun = (sum - MAX_ROW + 1) < 0 ? 0 : (sum - MAX_ROW + 1);
                for (int column = startColmun; column < MAX_COLUMN; column++) {
                    if (sum - column < 0) {
                        break;
                    }
                    res[index] = matrix[sum - column][column];
                    index++;
                }
            }
            // down
            else {
                // traverse row
                int startRow = (sum - MAX_COLUMN + 1) < 0 ? 0 : (sum - MAX_COLUMN + 1);
                for (int row = startRow; row < MAX_ROW; row++) {
                    if (sum - row < 0) {
                        break;
                    }
                    res[index] = matrix[row][sum - row];
                    index++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        LogUtils.d(TAG, diagonalTraverse.findDiagonalOrder(matrix));
    }
}
