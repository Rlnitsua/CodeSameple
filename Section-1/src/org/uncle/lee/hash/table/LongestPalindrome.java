package org.uncle.lee.hash.table;

import java.util.HashMap;
import java.util.Map;

import org.uncle.lee.log.LogUtils;

public class LongestPalindrome {
	private static final String TAG = "LongestPalindrome";
	
	public int longestPalindrome(String s) {
		Map<Character, Integer> chMap = new HashMap<Character, Integer>();
		int pairCount = 0;
		int singleCount = 0;
		
		for(char ch : s.toCharArray()){
			int chCount = chMap.get(ch) == null ? 0 : chMap.get(ch);
			chMap.put(ch, ++chCount);
		}
		
		for(int chCount : chMap.values()){
			pairCount += chCount >> 1;
			singleCount += chCount % 2;
		}
		
		return (pairCount << 1) + (singleCount == 0 ? 0 : 1);
	}
	
	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<>();
		LogUtils.d(TAG, map.get('x'));
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new LongestPalindrome().longestPalindrome("abccccdd"));
	}
}
