package lizbyu.dsa.stack;

import java.util.Stack;

public class ReverseString {
	public String reverseString(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] charArray = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			stack.push(charArray[i]);
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			sb.append(stack.pop());
		}

		return new String(sb);
	}
	
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(new ReverseString().reverseString(str));
	}
}
