package lizbyu.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.push(target);
            }
            if (i == s.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        return sb.toString();
    }
}
