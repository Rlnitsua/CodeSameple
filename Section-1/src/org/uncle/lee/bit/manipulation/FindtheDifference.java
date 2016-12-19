package org.uncle.lee.bit.manipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.uncle.lee.log.LogUtils;

public class FindtheDifference {
	private static final String TAG = "FindtheDifference";
	
	// abc - abec
	public char findTheDifference0(String s, String t) {
		int lo = 0;
		int hi = (s.length() - 1);
		
		while(lo <= hi){
			int mid = (lo + hi) >> 1;
			if(s.charAt(mid) == t.charAt(mid)){
				lo = mid + 1;
			} else {
				if(mid == 0){
					return t.charAt(mid);
				}else {
					if (s.charAt(mid - 1) == t.charAt(mid - 1)){
						return t.charAt(mid);
					} else {
						hi = mid - 1;
					}
				}
			}
		}
		return t.charAt(t.length() - 1);
	}
	
	public char findTheDifference(String s, String t) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for(int index = 0; index < t.length(); index++){
			int count = charMap.get(t.charAt(index)) == null ? 0 : charMap.get(t.charAt(index));
			charMap.put(t.charAt(index), (count + 1));
		}
		
		for(int index = 0; index < s.length(); index ++){
			charMap.put(s.charAt(index), (charMap.get(s.charAt(index)) - 1));
		}
		
		char differenceCh = 'a';
		for(Entry<Character, Integer> entry : charMap.entrySet()){
			if(entry.getValue() == 1){
				differenceCh = entry.getKey();
			}
		}
		return differenceCh;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, new FindtheDifference().findTheDifference("abcd", "abcdg"));
		LogUtils.d(TAG, new FindtheDifference().findTheDifference("abcd", "1abcd"));
		LogUtils.d(TAG, new FindtheDifference().findTheDifference("abcd", "a2bcd"));
		LogUtils.d(TAG, new FindtheDifference().findTheDifference("abcd", "abc3d"));
	}
}
