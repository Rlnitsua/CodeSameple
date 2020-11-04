package rlnitsua.stack;

import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        if (s.length() == 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (isNotGood(s.charAt(i), stack.peek())) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private boolean isNotGood(char ch1, char ch2) {
        return Math.abs(ch1 - ch2) == 32;
    }
}
