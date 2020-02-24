package lizbyu.string;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;

public class RepeatedSubstringPattern {
	private static final String TAG = "RepeatedSubstringPattern";
	
	public boolean repeatedSubstringPattern(String str) {
		if(str.length() == 1){
			return false;
		}
		
		List<Integer> divisorList = calculateDivisorList(str.length());
		char[] chArray = str.toCharArray();
		
		boolean errorDivesor = false;
		for(int divisor : divisorList){
			errorDivesor = false;
			for(int i = 0; i <= (divisor - 1); i++){
				int index = i;
				while(index < (str.length() - divisor)){
					if(chArray[index] != chArray[index + divisor]){
						if(divisor == divisorList.get(divisorList.size() - 1)){
							return false;
						} else {
							errorDivesor = true;
						}
					}
					index += divisor;
				}
			}
			if(!errorDivesor){
				return true;
			}
		}
		
		return false;
	}

	private List<Integer> calculateDivisorList(int length) {
		List<Integer> divisorList = new ArrayList<Integer>();
		for(int i = 1; i < length; i++){
			if(length % i == 0 && !divisorList.contains(i)){
				divisorList.add(i);
			}
		}
		return divisorList;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
//		LogUtils.d(TAG, new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
//		LogUtils.d(TAG, new RepeatedSubstringPattern().repeatedSubstringPattern("aba"));
//		LogUtils.d(TAG, new RepeatedSubstringPattern().repeatedSubstringPattern("abcabc"));
//		LogUtils.d(TAG, new RepeatedSubstringPattern().repeatedSubstringPattern("ababab"));
		LogUtils.d(TAG, new RepeatedSubstringPattern().repeatedSubstringPattern("aabaaba"));
	}
}
