package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class SparseMatrixMultiplication {
    private static final String TAG = "SparseMatrixMultiplication";

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];

        for (int row = 0; row < res.length; row++) {
            for (int column = 0; column < res[0].length; column++) {
                res[row][column] = calculateResElement(A[row], B, column);
            }
        }

        return res;
    }

    private int calculateResElement(int[] rowList, int[][] B, int columnIndex) {
        int sum = 0;
        for (int i = 0; i < rowList.length; i++) {
            sum += rowList[i] * B[i][columnIndex];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{-1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        LogUtils.d(TAG, new SparseMatrixMultiplication().multiply(A, B));
    }
}
