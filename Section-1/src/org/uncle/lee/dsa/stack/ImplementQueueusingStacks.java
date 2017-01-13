package org.uncle.lee.dsa.stack;

import java.util.Stack;

import org.uncle.lee.log.LogUtils;

public class ImplementQueueusingStacks {
	private static final String TAG = "ImplementQueueusingStacks";
	
	
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		LogUtils.d(TAG, queue.peek());
		queue.pop();
		LogUtils.d(TAG, queue.peek());
	}
}

class MyQueue {
	private Stack<Integer> stack;
	private Stack<Integer> tempStack;

	public MyQueue(){
		stack = new Stack<Integer>();
		tempStack = new Stack<Integer>();
	}
	
	// Push element x to the back of queue.
	public void push(int x) {
		stack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		while(!stack.isEmpty()){
			tempStack.push(stack.pop());
		}
		tempStack.pop();
		while(!tempStack.isEmpty()){
			stack.push(tempStack.pop());
		}
	}

	// Get the front element.
	public int peek() {
		while(!stack.isEmpty()){
			tempStack.push(stack.pop());
		}
		Integer pop = tempStack.peek();
		while(!tempStack.isEmpty()){
			stack.push(tempStack.pop());
		}
		return pop;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}
}