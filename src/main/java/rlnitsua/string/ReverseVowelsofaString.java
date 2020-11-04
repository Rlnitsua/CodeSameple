package rlnitsua.string;

import rlnitsua.utils.log.LogUtils;

import java.util.Stack;

public class ReverseVowelsofaString {
    private static final String TAG = "ReverseVowelsofaString";

    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }

        Stack<Character> vowelStack = new Stack<Character>();

        for (Character ch : s.toCharArray()) {
            if (isVowels(ch)) {
                vowelStack.push(ch);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < s.length(); index++) {
            char currentCh = s.charAt(index);
            if (isVowels(currentCh)) {
                sb.append(vowelStack.pop());
            } else {
                sb.append(currentCh);
            }
        }

        return new String(sb);
    }

    private boolean isVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O'
                || ch == 'U';
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new ReverseVowelsofaString().reverseVowels("Hello"));
    }
}
