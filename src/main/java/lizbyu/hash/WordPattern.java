package lizbyu.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lizbyu.utils.log.LogUtils;

public class WordPattern {
	private static final String TAG = "WordPattern";
	
	public boolean wordPattern(String pattern, String str) {
		if(pattern == null || pattern.length() == 0){
			return false;
		}
		
		Map<Character, String> map = new HashMap<Character, String>();
		char[] patternCh = pattern.toCharArray();
		String[] strCh = str.split(" ");
		
		if(patternCh.length != strCh.length){
			return false;
		}
		
		for(int i = 0; i < patternCh.length; i++){
			if(!map.containsKey(patternCh[i])){
				for(Entry<Character, String> entry : map.entrySet()){
					if(entry.getValue().equals(strCh[i])){
						return false;
					}
				}
				map.put(patternCh[i], strCh[i]);
			} else {
				if(!map.get(patternCh[i]).equals(strCh[i])){
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		LogUtils.d(TAG, new WordPattern().wordPattern("abba", "dog cat cat dog"));
	}
}
