package lizbyu.contest;

import lizbyu.utils.log.LogUtils;

public class UglyNumberIII {
    private static final String TAG = "UglyNumberIII";

    public int nthUglyNumber(int n, int a, int b, int c) {
        int num = 0;
        int res = 1;
        while (num != n) {
            if (res % a == 0 || res % b == 0 || res % c == 0) {
                num++;
            }
            if (num != n) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UglyNumberIII uglyNumberIII = new UglyNumberIII();
//		LogUtils.d(TAG, uglyNumberIII.nthUglyNumber(3, 2, 3, 5));
//		LogUtils.d(TAG, uglyNumberIII.nthUglyNumber(4, 2, 3, 4));
//		LogUtils.d(TAG, uglyNumberIII.nthUglyNumber(5, 2, 11, 13));
        LogUtils.d(TAG, uglyNumberIII.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}
