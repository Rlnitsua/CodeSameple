package rlnitsua.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> cacheMinStack;

    public MinStack() {
        stack = new LinkedList<>();
        cacheMinStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (cacheMinStack.isEmpty()) {
            cacheMinStack.push(x);
        } else {
            cacheMinStack.push(cacheMinStack.peek() < x ? cacheMinStack.peek() : x);
        }
    }

    public void pop() {
        stack.pop();
        cacheMinStack.pop();
    }

    public int top() {
        assert !stack.isEmpty();
        return stack.peek();
    }

    public int getMin() {
        assert !cacheMinStack.isEmpty();
        return cacheMinStack.peek();
    }
}
