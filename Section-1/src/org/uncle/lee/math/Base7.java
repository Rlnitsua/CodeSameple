package org.uncle.lee.math;

import java.util.Stack;

import org.uncle.lee.log.LogUtils;

public class Base7 {
	private static final String TAG = "Base7";

	public String convertToBase7(int num) {
		if(num > 0){
			return getBase7(num);
		} else if (num < 0){
			return "-" + getBase7(num * (-1));
		} else {
			return "0";
		}
	}

	public String getBase70(int num) {
		StringBuffer sb = new StringBuffer();
		while(num >= 1){
			sb.append(num % 7);
			num /= 7;
		}
		return new String(sb.reverse());
	}
	
	private String getBase7(int num) {
		Stack<Integer> stack = new Stack<Integer>();
		while(num >= 1){
			stack.push(num % 7);
			num /= 7;
		}
		
		StringBuffer sb = new StringBuffer();
		while(stack.size() != 0){
			sb.append(stack.pop());
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new Base7().convertToBase7(100));
		LogUtils.d(TAG, new Base7().convertToBase7(-7));
		LogUtils.d(TAG, new Base7().convertToBase7(-10));
	}
}
