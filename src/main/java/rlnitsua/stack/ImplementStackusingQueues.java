package rlnitsua.stack;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ImplementStackusingQueues {
    private Queue<Integer> queue;
    private Queue<Integer> tempQueue;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackusingQueues() {
        queue = new LinkedBlockingQueue<Integer>();
        tempQueue = new LinkedBlockingQueue<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        // poll all elements to tempQueue except last one
        while (queue.size() != 1) {
            tempQueue.offer(queue.poll());
        }

        // cache this element
        int keyElement = queue.poll();

        // poll all elements to queue
        while (tempQueue.size() != 0) {
            queue.offer(tempQueue.poll());
        }

        // return cached element
        return keyElement;
    }

    /**
     * Get the top element.
     */
    public int top() {
        // poll all elements to tempQueue except last one
        while (queue.size() != 1) {
            tempQueue.offer(queue.poll());
        }

        // cache this element
        int keyElement = queue.poll();

        // poll all elements to queue
        while (tempQueue.size() != 0) {
            queue.offer(tempQueue.poll());
        }

        // poll last element into queue
        queue.offer(keyElement);

        // return cached element
        return keyElement;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
