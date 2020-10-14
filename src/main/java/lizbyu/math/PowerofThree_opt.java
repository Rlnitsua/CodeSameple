package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class PowerofThree_opt {
    private static final String TAG = "PowerofThree_opt";

    public boolean isPowerOfThree(int n) {
        return (n > 0) && (1162261467 % n == 0);
    }

    private boolean isPowerOfThree_normal(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree_normal(n / 3);
    }

    private boolean containOtherDivisor(int number) {
        for (int i = 1; i <= number; i++) {
            if (number % i == 0 && !isPowerOfThree_normal(number / i)) {
                LogUtils.d(TAG, number / i + "is not power of three !!");
                return true;
            }
        }
        LogUtils.d(TAG, "All divisor of " + number + " is power of three ...");
        return false;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new PowerofThree_opt().containOtherDivisor(1162261467));
    }
}
