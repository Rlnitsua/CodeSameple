package lizbyu.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lizbyu.utils.log.LogUtils;

public class MinStack {
	private static final String TAG = "MinStack";
	List<Integer> numStack;
	List<Integer> minNumStack;

	/** initialize your data structure here. */
	public MinStack() {
		numStack = new ArrayList<Integer>();
		minNumStack = new ArrayList<Integer>();
	}

	public void push(int x) {
		numStack.add(x);
		minNumStack.add(x);
		Collections.sort(minNumStack);
	}

	public void pop() {
		Integer num = numStack.get(numStack.size() - 1);
		numStack.remove(numStack.size() - 1);
		minNumStack.remove(Integer.valueOf(num));
	}

	public int top() {
		return numStack.get(numStack.size() - 1);
	}

	public int getMin() {
		return minNumStack.get(0);
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(2);
		obj.pop();
		LogUtils.d(TAG, obj.top());
		LogUtils.d(TAG, obj.getMin());
	}
}
