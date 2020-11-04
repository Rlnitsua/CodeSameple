package rlnitsua.easy;

import rlnitsua.utils.log.LogUtils;

public class ConstructtheRectangle {
    private static final String TAG = "ConstructtheRectangle";

    public int[] constructRectangle(int area) {
        int[] res = new int[2];

        double sqrt = Math.sqrt(area);
        if (area % sqrt == 0) {
            res[0] = (int) sqrt;
            res[1] = (int) sqrt;
            return res;
        }

        for (int i = (int) (sqrt + 1); i <= area; i++) {
            if (area % i == 0) {
                res[0] = i;
                res[1] = area / i;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new ConstructtheRectangle().constructRectangle(4));
        LogUtils.d(TAG, new ConstructtheRectangle().constructRectangle(8));
        LogUtils.d(TAG, new ConstructtheRectangle().constructRectangle(9));
        LogUtils.d(TAG, new ConstructtheRectangle().constructRectangle(27));
        LogUtils.d(TAG, new ConstructtheRectangle().constructRectangle(47));
    }
}
