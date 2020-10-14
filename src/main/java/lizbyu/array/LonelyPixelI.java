package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class LonelyPixelI {
    private static final String TAG = "LonelyPixelI";

    public int findLonelyPixel(char[][] picture) {
        int count = 0;

        for (int row = 0; row < picture.length; row++) {
            int pixelNum = 0;
            int columnIndex = 0;
            for (int column = 0; column < picture[0].length; column++) {
                if (pixelNum > 1) {
                    break;
                }
                if (picture[row][column] == 'B') {
                    pixelNum++;
                    columnIndex = column;
                }
            }
            if (pixelNum == 1) {
                if (checkColumn(picture, columnIndex)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean checkColumn(char[][] picture, int columnIndex) {
        int pixelNum = 0;
        for (int i = 0; i < picture.length; i++) {
            if (pixelNum > 1) {
                return false;
            }
            if (picture[i][columnIndex] == 'B') {
                pixelNum++;
            }
        }
        return pixelNum == 1;
    }

    public static void main(String[] args) {
        char[][] inputs = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
        LogUtils.d(TAG, new LonelyPixelI().findLonelyPixel(inputs));
    }
}
