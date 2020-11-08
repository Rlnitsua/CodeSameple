package rlnitsua.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackQueueTest {

    @Test
    public void test() {
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        stackQueue.push(5);
        assertEquals(1, stackQueue.pop());
        assertEquals(2, stackQueue.pop());
        assertEquals(3, stackQueue.pop());
        assertEquals(4, stackQueue.pop());
        stackQueue.push(6);
        assertEquals(5, stackQueue.pop());
        assertEquals(6, stackQueue.pop());
    }
}