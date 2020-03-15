package lizbyu.contest;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {
    private List<Integer> stack;
    private int maxSize = -1;

    public CustomStack(int maxSize) {
        this.stack = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.add(x);
        }
    }

    public int pop() {
        if (stack.size() == 0) {
            return -1;
        } else {
            int res = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return res;
        }
    }

    public void increment(int k, int val) {
        if (stack.size() <= k) {
            for (int i = 0; i < stack.size(); i++) {
                stack.set(i, stack.get(i) + val);
            }
        } else {
            for (int i = 0; i <= stack.size() - k; i++) {
                stack.set(i, stack.get(i) + val);
            }
        }
    }

    /**
     * CustomStack customStack = new CustomStack(3); // Stack is Empty []
     * customStack.push(1);                          // stack becomes [1]
     * customStack.push(2);                          // stack becomes [1, 2]
     * customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
     * customStack.push(2);                          // stack becomes [1, 2]
     * customStack.push(3);                          // stack becomes [1, 2, 3]
     * customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
     * customStack.increment(5, 100);                // stack becomes [101, 102, 103]
     * customStack.increment(2, 100);                // stack becomes [201, 202, 103]
     * customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
     * customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
     * customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
     * customStack.pop();
     * @param args
     */
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        int pop = customStack.pop();
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        int pop1 = customStack.pop();
        int pop2 = customStack.pop();
        int pop3 = customStack.pop();
        int pop4 = customStack.pop();
        int pop5 = customStack.pop();
    }
}