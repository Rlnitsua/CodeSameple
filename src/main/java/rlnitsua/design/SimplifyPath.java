package rlnitsua.design;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();

        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!item.equals("") && !item.equals(".")) {
                stack.push(item);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }
        return sb.toString();
    }
}
