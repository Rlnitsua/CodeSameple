package rlnitsua.stack;


import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
