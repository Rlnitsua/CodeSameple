package lizbyu.bit;

import lizbyu.utils.log.LogUtils;

public class NumberComplement {
    private static final String TAG = "NumberComplement";

    public int findComplement(int num) {
        int numTemp = num;
        int num1 = 0;
        int pow = 0;

        while (num >= 1) {
            num >>= 1;
            num1 += Math.pow(2, pow);
            pow++;
        }

        return numTemp ^ num1;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new NumberComplement().findComplement(5));
        LogUtils.d(TAG, new NumberComplement().findComplement(1));
    }
}
