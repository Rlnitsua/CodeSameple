package lizbyu.hash;

import java.util.HashMap;
import java.util.Map;

import lizbyu.utils.log.LogUtils;

public class ValidAnagram {
	private static final String TAG = "ValidAnagram";
	
	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> chMap = new HashMap<Character, Integer>();
		
		for(char ch : s.toCharArray()){
			int chCount = chMap.get(ch) == null ? 0 : chMap.get(ch);
			chMap.put(ch, ++chCount);
		}
		
		for(char ch : t.toCharArray()){
			if(!chMap.containsKey(ch)){
				return false;
			}else {
				chMap.put(ch, (chMap.get(ch) - 1));
			}
		}
		
		for(int chCount : chMap.values()){
			if(chCount != 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		String s = "anagram", t = "nagaram";
		LogUtils.d(TAG, new ValidAnagram().isAnagram(s, t));
	}
}
