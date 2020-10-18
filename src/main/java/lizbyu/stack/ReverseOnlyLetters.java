package lizbyu.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] other = new char[s.length()];
        Arrays.fill(other, 'a');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                stack.push(ch);
            } else {
                other[i] = ch;
            }
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();

        while (index < s.length()) {
            if (other[index] == 'a') {
                sb.append(stack.pop());
            } else {
                sb.append(other[index]);
            }
            index++;
        }
        return sb.toString();
    }
}
