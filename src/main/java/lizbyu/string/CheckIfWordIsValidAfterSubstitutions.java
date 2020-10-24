package lizbyu.string;

import java.util.Deque;
import java.util.LinkedList;

public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == 'c') {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.peek() == 'b') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == 'a') {
                        stack.pop();
                    } else {
                        stack.push('b');
                    }
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
