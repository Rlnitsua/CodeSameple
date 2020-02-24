package lizbyu.string;

import java.util.HashMap;
import java.util.Map;

import lizbyu.utils.log.LogUtils;

public class RansomNote {
	private static final String TAG = "RansomNote";
	
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> magazineMap = getMapFromString(magazine);
		
		for(char ch : ransomNote.toCharArray()){
			if(magazineMap.containsKey(ch)){
				if(magazineMap.get(ch) == 1){
					magazineMap.remove(ch);
				} else {
					magazineMap.put(ch, (magazineMap.get(ch) - 1));
				}
			} else {
				return false;
			}
		}
		return true;
	}

	private Map<Character, Integer> getMapFromString(String magazine) {
		Map<Character, Integer> magazineMap = new HashMap<Character, Integer>();
		for(char ch : magazine.toCharArray()){
			int charCount = magazineMap.get(ch) == null ? 0 : magazineMap.get(ch);
			magazineMap.put(ch, ++charCount);
		}
		return magazineMap;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		String aStr = "aac";
		String bStr = "aab";
		LogUtils.d(TAG, new RansomNote().canConstruct(aStr, bStr));
	}
}
