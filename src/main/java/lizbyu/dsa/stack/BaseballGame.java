package lizbyu.dsa.stack;

import java.util.Stack;

import lizbyu.utils.log.LogUtils;

public class BaseballGame {
	private static final String TAG = "BaseballGame";
	private int res = 0;
	
	public int calPoints(String[] ops) {
		res = 0;
		Stack<Integer> opsStack = new Stack<>();
		
		for (String op : ops) {
			switch(op) {
				case "+":
					handlePlusOperator(opsStack);
					break;
				case "D":
					handleDoubleOperator(opsStack);
					break;
				case "C":
					handleCancelOperator(opsStack);
					break;
				default:
					handleNumberOperator(op, opsStack);
					break;
			}
		}
		
		return res;
	}

	private void handlePlusOperator(Stack<Integer> opsStack) {
		if (opsStack.size() == 0) {
			return;
		} else if (opsStack.size() == 1) {
			Integer lastNum = opsStack.peek();
			opsStack.push(lastNum);
			res += lastNum;
		} else {
			Integer lastNum = opsStack.peek();
			opsStack.pop();
			Integer secondNum = opsStack.peek();
			opsStack.push(lastNum);
			int newNum = lastNum + secondNum;
			opsStack.push(newNum);
			res += newNum;
		}
	}

	private void handleDoubleOperator(Stack<Integer> opsStack) {
		if (opsStack.size() != 0) {
			int lastNum = opsStack.peek();
			opsStack.push(lastNum * 2);
			res += lastNum * 2;
		}
	}

	private void handleCancelOperator(Stack<Integer> opsStack) {
		if (opsStack.size() != 0) {
			int lastNum = opsStack.pop();
			res -= lastNum;
		}
	}

	private void handleNumberOperator(String op, Stack<Integer> opsStack) {
		opsStack.push(Integer.valueOf(op));
		res += Integer.valueOf(op);
	}
	
	public static void main(String[] args) {
		String[] strArr = new String[]{"5", "2", "C", "D", "+"};
		String[] strArr1 = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
		LogUtils.d(TAG, new BaseballGame().calPoints(strArr));
		LogUtils.d(TAG, new BaseballGame().calPoints(strArr1));
	}
}
