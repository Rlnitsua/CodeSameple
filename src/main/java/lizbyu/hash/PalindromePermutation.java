package lizbyu.hash;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		Map<Character, Integer> chMap = new HashMap<Character, Integer>();
		for(char ch : s.toCharArray()){
			int count = chMap.get(ch) == null ? 0 : chMap.get(ch);
			chMap.put(ch, count + 1);
		}
		
		int singleCount = 0;
		for(int count : chMap.values()){
			if(count % 2 == 1){
				singleCount++;
				if(singleCount > 1){
					return false;
				}
			}
		}
		return true;
	}
}
