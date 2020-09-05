package lizbyu.array;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int n = Math.max(0, i - K); n <= Math.min(mat.length - 1, i + K); n++) {
                    for (int m = Math.max(0, j - K); m <= Math.min(mat[0].length - 1, j + K); m++) {
                        res[i][j] += mat[n][m];
                    }
                }
            }
        }

        return res;
    }
}
