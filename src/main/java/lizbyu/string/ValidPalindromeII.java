package lizbyu.string;

import lizbyu.utils.log.LogUtils;

public class ValidPalindromeII {
    private static final String TAG = "ValidPalindromeII";

    public boolean validPalindrome(String s) {
        if (isPalindrome(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String word) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < (wordArr.length / 2); i++) {
            if (wordArr[i] != wordArr[wordArr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String word, int index) {
        boolean isIndex = false;
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < (wordArr.length / 2); i++) {
            if (i == index) {
                isIndex = true;
                continue;
            }
            if (isIndex) {
                if (wordArr[i] != wordArr[wordArr.length - i]) {
                    return false;
                }
            } else {
                if (wordArr[i] != wordArr[wordArr.length - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new ValidPalindromeII().validPalindrome("aba"));
        LogUtils.d(TAG, new ValidPalindromeII().validPalindrome("abca"));
        LogUtils.d(TAG, new ValidPalindromeII().validPalindrome("acbca"));
    }
}
