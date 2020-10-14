package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class ReverseInteger {
    private static final String TAG = "ReverseInteger";

    public int reverse(int x) {
        boolean isNegtive = x < 0 ? true : false;

        StringBuffer res = new StringBuffer();
        x = Math.abs(x);

        while (x > 0) {
            res.append(x % 10);
            x /= 10;
        }

        try {
            int resInt = Integer.valueOf(new String(res));
            return isNegtive ? resInt * (-1) : resInt;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new ReverseInteger().reverse(123));
        LogUtils.d(TAG, new ReverseInteger().reverse(-123));
        LogUtils.d(TAG, new ReverseInteger().reverse(1247489999));
    }
}
