package lizbyu.string;

import lizbyu.utils.log.LogUtils;

import java.util.Stack;

public class ValidParenthesisString {
    private static final String TAG = "ValidParenthesisString";

    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        return checkValidString(sArr[0], 0, sArr, stack);
    }

    @SuppressWarnings("unchecked")
    private boolean checkValidString(char currentCh, int currentIndex, char[] sArr, Stack<Character> stack) {
        sArr[currentIndex] = currentCh;
        for (int i = currentIndex; i < sArr.length; i++) {
            if (sArr[i] == '(') {
                stack.push(sArr[i]);
            } else if (sArr[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (sArr[i] == '*') {
                return checkValidString('(', i, sArr, (Stack<Character>) stack.clone())
                        || checkValidString(')', i, sArr, (Stack<Character>) stack.clone())
                        || checkValidString(' ', i, sArr, (Stack<Character>) stack.clone());
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new ValidParenthesisString().checkValidString("(*)"));
    }
}
