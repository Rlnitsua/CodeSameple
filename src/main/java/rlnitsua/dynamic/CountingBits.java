package rlnitsua.dynamic;

import rlnitsua.utils.log.LogUtils;

public class CountingBits {
    private static final String TAG = "CountingBits";

    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i % 2);
        }

        return res;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new CountingBits().countBits(5));
    }
}
