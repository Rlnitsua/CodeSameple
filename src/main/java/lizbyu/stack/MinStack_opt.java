package lizbyu.stack;

import java.util.Stack;


public class MinStack_opt {
    private Stack<Long> stack = new Stack<Long>();
    private long min = Long.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack_opt() {
    }

    public void push(int x) {
        if (min == Integer.MAX_VALUE) {
            stack.push(0L);
            min = (long) x;
        } else {
            stack.push(x - min);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        if (stack.size() == 0) {
            return;
        } else {
            long pop = stack.pop();
            if (pop < 0) {
                min -= pop;
            }
        }
    }

    public int top() {
        long peek = stack.peek();
        if (peek > 0) {
            return (int) (min + peek);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
