package lizbyu.array;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                flipRow(A, i);
            }
        }

        for (int j = 0; j < A[0].length; j++) {
            int zeroCount = 0;
            int oneCount = 0;

            for (int[] column : A) {
                if (column[j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if (zeroCount > oneCount) {
                flipColumn(A, j);
            }
        }

        return calculateScore(A);
    }

    private void flipRow(int[][] A, int row) {
        for (int j = 0; j < A[0].length; j++) {
            if (A[row][j] == 0) {
                A[row][j] = 1;
            } else {
                A[row][j] = 0;
            }
        }
    }

    private void flipColumn(int[][] A, int column) {
        for (int[] ints : A) {
            if (ints[column] == 0) {
                ints[column] = 1;
            } else {
                ints[column] = 0;
            }
        }
    }

    private int calculateScore(int[][] A) {
        int score = 0;
        int base = 1;

        for (int j = A[0].length - 1; j >= 0; j--) {
            for (int[] ints : A) {
                score += ints[j] * base;
            }
            base *= 2;
        }

        return score;
    }
}
