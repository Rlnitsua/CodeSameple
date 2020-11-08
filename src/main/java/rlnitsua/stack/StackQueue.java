package rlnitsua.stack;


import java.util.Deque;
import java.util.LinkedList;

public class StackQueue {
    private final Deque<Integer> stackPush = new LinkedList<>();
    private final Deque<Integer> stackPop = new LinkedList<>();

    public void push(int node) {
        stackPush.push(node);
    }

    public int pop() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.isEmpty() ? -1 : stackPop.peek();
    }

}
