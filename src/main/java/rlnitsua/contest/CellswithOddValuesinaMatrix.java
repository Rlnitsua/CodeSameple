package rlnitsua.contest;

import rlnitsua.utils.log.LogUtils;

public class CellswithOddValuesinaMatrix {
    private static final String TAG = "CellswithOddValuesinaMatrix";

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            handleMatrix(matrix, indices[i]);
        }

        return calculateOddCells(matrix);
    }

    private void handleMatrix(int[][] matrix, int[] indice) {
        int row = indice[0];
        int column = indice[1];

        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i]++;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column]++;
        }
    }

    private int calculateOddCells(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CellswithOddValuesinaMatrix matrix = new CellswithOddValuesinaMatrix();
        int[][] indices0 = {{0, 1}, {1, 1}};
        LogUtils.d(TAG, "res0 : " + matrix.oddCells(2, 3, indices0));
        int[][] indices1 = {{1, 1}, {0, 0}};
        LogUtils.d(TAG, "res0 : " + matrix.oddCells(2, 2, indices1));

    }
}
