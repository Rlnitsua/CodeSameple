package rlnitsua.stack;

import rlnitsua.utils.log.LogUtils;

import java.util.Stack;

public class ValidParentheses {
    private static final String TAG = "ValidParentheses";

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == ')' || ch == '[' || ch == ']' ||
                    ch == '{' || ch == '}') {
                if (stack.size() == 0 || !isMathching(ch, stack.peek())) {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() == 0;
    }

    private boolean isMathching(char ch, char topE) {
        if (ch == ')') {
            return topE == '(';
        } else if (ch == ']') {
            return topE == '[';
        } else if (ch == '}') {
            return topE == '{';
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new ValidParentheses().isValid("()"));
    }
}
