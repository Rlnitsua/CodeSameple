package lizbyu.string;

import lizbyu.utils.log.LogUtils;

import java.util.Stack;

public class BinaryNumberwithAlternatingBits {
    private static final String TAG = "BinaryNumberwithAlternatingBits";

    public boolean hasAlternatingBits(int n) {
        String bitStr = getBitFromNum(n);

        boolean isOne = true;
        for (char ch : bitStr.toCharArray()) {
            if (ch != getCh(isOne)) {
                return false;
            }
            isOne = !isOne;
        }
        return true;
    }

    private char getCh(boolean isOne) {
        return isOne ? '1' : '0';
    }

    private String getBitFromNum(int n) {
        Stack<Integer> stack = new Stack<>();

        while (n / 2 > 0) {
            stack.push(n % 2);
            n >>= 1;
        }
        if (n == 1) {
            stack.push(1);
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        BinaryNumberwithAlternatingBits bnab = new BinaryNumberwithAlternatingBits();
        LogUtils.d(TAG, bnab.hasAlternatingBits(5));
        LogUtils.d(TAG, bnab.hasAlternatingBits(7));
        LogUtils.d(TAG, bnab.hasAlternatingBits(9));
    }
}
