package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class PowerofTwo {
    private static final String TAG = "PowerofTwo";

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0 || n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n >> 1);
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new PowerofTwo().isPowerOfTwo(1));
    }
}
