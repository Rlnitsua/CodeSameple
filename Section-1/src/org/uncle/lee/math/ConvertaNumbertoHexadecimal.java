package org.uncle.lee.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.uncle.lee.log.LogUtils;

public class ConvertaNumbertoHexadecimal {
	private static final String TAG = "ConvertaNumbertoHexadecimal";
	
	public String toHex(int num) {
		String hexStr = null;
		if(num > 0){
			hexStr = getPositiveHex(num);
		} else if (num < 0){
			hexStr = toHex(Math.abs(num));
			hexStr = changeToNagetive(hexStr);
		} else {
			hexStr = "0";
		}
		return hexStr;
	}

	private String getPositiveHex(int num) {
		Stack<Character> stack = new Stack<Character>();
		while(num >= 1){
			if(num % 16 > 10){
				
			}else {
				stack.push((char) (num % 16));
			}
			char ch = numMap.get(num % 16);
			num /= 16;
		}
		StringBuffer sb = new StringBuffer();
		while(stack.size() > 0){
			sb.append(stack.pop());
		}
		return new String(sb);
	}

	private String changeToNagetive(String hexStr) {
		char[] chArray = hexStr.toCharArray();
		for(int i = 0; i < chArray.length; i++){
			chArray[i] = 
		}
		return null;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new ConvertaNumbertoHexadecimal().toHex(5613));
	}
}
