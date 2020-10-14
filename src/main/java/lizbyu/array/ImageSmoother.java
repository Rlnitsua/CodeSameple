package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class ImageSmoother {
    private static final String TAG = "ImageSmoother";

    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];

        for (int row = 0; row < res.length; row++) {
            for (int column = 0; column < res[0].length; column++) {
                res[row][column] = caculate(M, row, column);
            }
        }

        return res;
    }

    private int caculate(int[][] m, int row, int column) {
        int num = 0;
        int numCount = 0;

        num += m[row][column];
        numCount++;

        if (isFirstRow(row, m)) {
            // do nothing
        } else {
            num += m[row - 1][column];
            numCount++;
        }

        if (isFirstRow(row, m) || isFirstColumn(column, m)) {
            // do nothing
        } else {
            num += m[row - 1][column - 1];
            numCount++;
        }

        if (isFirstColumn(column, m)) {
            // do nothing
        } else {
            num += m[row][column - 1];
            numCount++;
        }

        if (isFirstColumn(column, m) || isLastRow(row, m)) {
            // do nothing
        } else {
            num += m[row + 1][column - 1];
            numCount++;
        }

        if (isLastRow(row, m)) {
            // do nothing
        } else {
            num += m[row + 1][column];
            numCount++;
        }

        if (isLastRow(row, m) || isLastColumn(column, m)) {
            // do nothing
        } else {
            num += m[row + 1][column + 1];
            numCount++;
        }

        if (isLastColumn(column, m)) {
            // do nothing
        } else {
            num += m[row][column + 1];
            numCount++;
        }

        if (isLastColumn(column, m) || isFirstRow(row, m)) {
            // do nothing
        } else {
            num += m[row - 1][column + 1];
            numCount++;
        }

        return num / numCount;
    }

    private boolean isFirstRow(int row, int[][] m) {
        return row == 0;
    }

    private boolean isFirstColumn(int column, int[][] m) {
        return column == 0;
    }

    private boolean isLastRow(int row, int[][] m) {
        return row == m.length - 1;
    }

    private boolean isLastColumn(int column, int[][] m) {
        return column == m[0].length - 1;
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//		int[][] M = new int[][] {{2,3,4}, {5,6,7}, {8,9,10}, {11,12,13}, {14,15,16}};
        LogUtils.d(TAG, new ImageSmoother().imageSmoother(M));
    }
}
