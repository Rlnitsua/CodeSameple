package org.uncle.lee.dynamic;

import org.uncle.lee.log.LogUtils;

public class PalindromicSubstrings {
	private static final String TAG = "PalindromicSubstrings";
	
	public int countSubstrings(String s) {
		if(s == null) {
			return 0;
		}
		
		// base
		if(s.length() == 1) {
			return 1;
		}
		
		return countSubstrings(s.substring(0, s.length() - 1)) + 
				countLastPalindromic(s);
	}

	private int countLastPalindromic(String s) {
		int count = 1;
		for(int i = 0; i < s.length() - 1; i++) {
			if(isPalindromic(s.substring(i, s.length()))) {
				count++;
			}
		}
		return count;
	}
	
	private boolean isPalindromic(String s) {
		if(s.length() == 1) {
			return true;
		}
		
		char[] sArr = s.toCharArray();
		int mid = s.length() % 2 == 0 ? s.length() / 2 - 1 : (s.length() - 1) / 2;
		for(int i = 0; i <= mid; i++) {
			if(sArr[i] != sArr[s.length() - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "abc";
		LogUtils.d(TAG, new PalindromicSubstrings().countSubstrings(s));
	}
}
