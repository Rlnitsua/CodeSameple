package rlnitsua.bit;

import rlnitsua.utils.log.LogUtils;

import java.util.Stack;

public class ReverseBits {
    private static final String TAG = "ReverseBits";

    // you need treat n as an unsigned value
    public int reverseBits0(int n) {
        if (n == 1) {
            int res = 1;
            int x = 31;
            while (x > 0) {
                res <<= 1;
                x--;
            }
            return res;
        }

        Stack<Integer> stack = new Stack<Integer>();

        while (n > 0) {
            stack.push(n % 2);
            n >>= 1;
        }

        StringBuffer sb = new StringBuffer();
        int stackLength = stack.size();
        while (stack.size() != 0) {
            sb.append(String.valueOf(stack.pop()));
        }

        int sum = 0;
        int power = 32 - stackLength;

        for (char ch : sb.toString().toCharArray()) {
            if (ch == '1') {
                sum += Math.pow(2, power);
            }
            power++;
        }

        return sum;
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1; // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new ReverseBits().reverseBits(1));
//		LogUtils.d(TAG, new ReverseBits().reverseBits(2147483648));
        LogUtils.d(TAG, Math.pow(2, 31));
        LogUtils.d(TAG, (int) Math.pow(2, 31));
    }

}
