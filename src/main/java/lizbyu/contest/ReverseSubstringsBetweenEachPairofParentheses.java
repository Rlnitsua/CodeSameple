package lizbyu.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lizbyu.utils.log.LogUtils;

//Input: s = "(abcd)"
//Output: "dcba"
//Example 2:
//
//Input: s = "(u(love)i)"
//Output: "iloveu"
//Example 3:
//
//Input: s = "(ed(et(oc))el)"
//Output: "leetcode"
//Example 4:
//
//Input: s = "a(bcdefghijkl(mno)p)q"
//Output: "apmnolkjihgfedcbq"

public class ReverseSubstringsBetweenEachPairofParentheses {
	private static final String TAG = "ReverseSubstringsBetweenEachPairofParentheses";
	
	public String reverseParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch != ')') {
				stack.push(ch);
			} else {
				// fetch the char list
				List<Character> list = new ArrayList<>();
				while (!stack.isEmpty()) {
					char top = stack.pop();
					if (top == '(') {
						break;
					} else {
						list.add(top);
					}
				}
				// push into stack
				for (char chNew : list) {
					stack.push(chNew);
				}
			}
		}
		
		StringBuffer res = new StringBuffer();
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return res.reverse().toString();
	}
	
	public static void main(String[] args) {
		ReverseSubstringsBetweenEachPairofParentheses parentheses = new ReverseSubstringsBetweenEachPairofParentheses();
		LogUtils.d(TAG, parentheses.reverseParentheses("(abcd)"));
		LogUtils.d(TAG, parentheses.reverseParentheses("(u(love)i)"));
		LogUtils.d(TAG, parentheses.reverseParentheses("(ed(et(oc))el)"));
		LogUtils.d(TAG, parentheses.reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}
}
