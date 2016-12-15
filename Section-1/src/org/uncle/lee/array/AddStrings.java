package org.uncle.lee.array;

import java.util.Stack;

/*
 * describe addition in coding
 */

public class AddStrings {
	public String addStrings(String num1, String num2) {
		Stack<Integer> stack1 = getStack(num1);
		Stack<Integer> stack2 = getStack(num2);
		return addBigInteger(stack1, stack2);
	}

	// use stack to reverse integer
	private Stack<Integer> getStack(String num) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] numArray = num.toCharArray();
		for(char numCh : numArray){
			stack.push(Integer.valueOf(numCh) - 48);
		}
		return stack;
	}
	
	private String addBigInteger(Stack<Integer> stack1, Stack<Integer> stack2) {
		StringBuffer sb = new StringBuffer();
		boolean isCarryBit = false;
		int maxSize = stack1.size() > stack2.size() ? stack1.size() : stack2.size();
		
		// set StringBuffer value
		for(int i = 0; i < maxSize; i++){
			int num1 = stack1.size() == 0 ? 0 : stack1.pop();
			int num2 = stack2.size() == 0 ? 0 : stack2.pop();
			
			int num = num1 + num2 + (isCarryBit ? 1 : 0);
			isCarryBit = false;
			if(num >= 10){
				isCarryBit = true;
				num %= 10;
			}
			sb.append(num);
		}
		
		// if isCarryBit is true, it means that new carry bit is existed
		if(isCarryBit){
			sb.append(1);
		}
		return new String(sb.reverse());
	}
	
	public static void main(String[] args) {
		String num1 = "64615619848948946516153216498489487984132513216544798748946513132165498479879465146513516549870";
		String num2 = "6461561984894894651615321649848948798413251321654479874894651313216549847987946514651351654987";
//		String num1 = "123";
//		String num2 = "900";
		System.out.println(new AddStrings().addStrings(num1, num2));
	}
}
