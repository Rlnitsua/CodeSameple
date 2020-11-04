package rlnitsua.math;

import rlnitsua.utils.log.LogUtils;

public class ArrangingCoins {
    private static final String TAG = "ArrangingCoins";

    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }

        long lo = 0;
        long hi = Math.abs(n);
        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long preNValue = (mid * (mid + 1)) >> 1;
            long afterNValue = preNValue + mid + 1;
            if (n == afterNValue) {
                return (int) (mid + 1);
            } else if (n < preNValue) {
                hi = mid;
            } else if (n > afterNValue) {
                lo = mid;
            } else {
                return (int) mid;
            }
        }
        return (int) lo;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new ArrangingCoins().arrangeCoins(5));
        LogUtils.d(TAG, new ArrangingCoins().arrangeCoins(8));
        LogUtils.d(TAG, new ArrangingCoins().arrangeCoins(1));
        LogUtils.d(TAG, new ArrangingCoins().arrangeCoins(2));
        LogUtils.d(TAG, new ArrangingCoins().arrangeCoins(3));
        LogUtils.d(TAG, new ArrangingCoins().arrangeCoins(1804289383));
    }
}
