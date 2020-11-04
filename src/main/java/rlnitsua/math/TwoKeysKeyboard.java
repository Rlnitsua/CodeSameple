package rlnitsua.math;

import rlnitsua.utils.log.LogUtils;

public class TwoKeysKeyboard {
    private static final String TAG = "TwoKeysKeyboard";

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }

        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                res += i;
                res += minSteps(n / i);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new TwoKeysKeyboard().minSteps(5));
        LogUtils.d(TAG, new TwoKeysKeyboard().minSteps(16));
        LogUtils.d(TAG, new TwoKeysKeyboard().minSteps(32));
        LogUtils.d(TAG, new TwoKeysKeyboard().minSteps(35));
    }
}
