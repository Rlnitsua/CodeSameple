package lizbyu.string;

import java.util.Stack;

import lizbyu.utils.log.LogUtils;

public class ValidPalindrome {
	private static final String TAG = "ValidPalindrome";
	private Stack<Character> stack = new Stack<Character>();

	public boolean isPalindrome(String s) {
		for (char ch : s.toCharArray()) {
			if(isNum(ch) || isLetter(ch)){
				stack.push(ch);
			}
		}
		
		for (char ch : s.toCharArray()){
			if(isNum(ch) || isLetter(ch)){
				if(!isEqual(ch, stack.pop())){
					return false;
				}
			}
		}
		
		return true;
	}

	private boolean isNum(char ch) {
		boolean isLegal = false;
		isLegal |= ((int)ch >= 48 && (int)ch <= 57);
		return isLegal;
	}
	
	private boolean isLetter(char ch) {
		boolean isLegal = false;
		isLegal |= ((int)ch >= 65 && (int)ch <= 90);
		isLegal |= ((int)ch >= 97 && (int)ch <= 122);
		return isLegal;
	}
	
	private boolean isEqual(char ch1, char ch2){
		return ch1 == ch2 ||
				(isLetter(ch1) && isLetter(ch2) && Math.abs((int)ch1 - (int)ch2) == 32);
	}

	public static void main(String[] args) {
		LogUtils.d(TAG, new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
		LogUtils.d(TAG, new ValidPalindrome().isPalindrome("race a car"));
		LogUtils.d(TAG, new ValidPalindrome().isPalindrome("0P"));
	}
}
