package lizbyu.math;

import java.util.HashMap;
import java.util.Map;

import lizbyu.utils.log.LogUtils;

public class RomantoInteger {
	private static final String TAG = "RomantoInteger";
	
	public int romanToInt(String s) {
		int sum = 0;
		Map<Character, Integer> valueMap = initMap();
		char[] chArray = s.toCharArray();
		
		for(int i = 0; i < (chArray.length - 1); i++){
			if(valueMap.get(chArray[i]) >= valueMap.get(chArray[i + 1])){
				sum += valueMap.get(chArray[i]);
			}else {
				sum -= valueMap.get(chArray[i]);
			}
		}
		sum += valueMap.get(chArray[chArray.length - 1]);
		
		return sum;
	}

	private Map<Character, Integer> initMap() {
		Map<Character, Integer> valueMap = new HashMap<Character, Integer>();
		valueMap.put('M', 1000);
		valueMap.put('D', 500);
		valueMap.put('C', 100);
		valueMap.put('L', 50);
		valueMap.put('X', 10);
		valueMap.put('V', 5);
		valueMap.put('I', 1);
		return valueMap;
	}
	
	public static void main(String[] args) {
		String romanNum = "MCDXXXVII";
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new RomantoInteger().romanToInt(romanNum));
	}
}
