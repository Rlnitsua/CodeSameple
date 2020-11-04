package rlnitsua.math;

import rlnitsua.utils.log.LogUtils;

public class PalindromeNumber {
    private static final String TAG = "PalindromeNumber";

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int length = 0;
        int num = x;
        while (num >= 1) {
            length++;
            num /= 10;
        }

        for (int i = 1; i <= (length >> 1); i++) {
            if (getBiteNum(x, i) != getBiteNum(x, length + 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private int getBiteNum(int num, int index) {
        num /= Math.pow(10, index - 1);
        num %= 10;
        return num;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "Start");
        LogUtils.d(TAG, new PalindromeNumber().isPalindrome(1001));
        LogUtils.d(TAG, new PalindromeNumber().isPalindrome(10011));
    }
}
