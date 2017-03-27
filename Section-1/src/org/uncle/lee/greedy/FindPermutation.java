package org.uncle.lee.greedy;

import org.uncle.lee.log.LogUtils;

public class FindPermutation {
	private static final String TAG = "FindPermutation";
	
	public int[] findPermutation(String s) {
		int[] res = createIntRes(s.length() + 1);

		char[] chArr = s.toCharArray();
		int startIndex = -1;
		int endIndex = -1;
		
		for(int i = 0; i < chArr.length; i++){
			if(chArr[i] == 'I'){
				if(startIndex != -1){
					reverseArr(res, startIndex, endIndex + 1 >= res.length 
							? res.length - 1 : endIndex + 1);
					startIndex = -1;
					endIndex = -1;
				}
			} else {
				if(startIndex == -1){
					startIndex = i;
					endIndex = i;
				} else {
					endIndex++;
				}
			}
		}
		
		if(startIndex != -1){
			reverseArr(res, startIndex, endIndex + 1 >= res.length 
					? res.length - 1 : endIndex + 1);
			startIndex = -1;
			endIndex = -1;
		}
		return res;
	}

	private int[] createIntRes(int length) {
		int[] res = new int[length];
		for(int i = 0; i < res.length; i++){
			res[i] = i + 1;
		}
		return res;
	}
	
	private void reverseArr(int[] res, int startIndex, int endIndex) {
		for(int i = startIndex; i <= ((startIndex + endIndex) >> 1); i++){
			int temp = res[i];
			res[i] = res[startIndex + endIndex - i];
			res[startIndex + endIndex - i] = temp;
		}
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, new FindPermutation().findPermutation("D"));
//		LogUtils.d(TAG, new FindPermutation().findPermutation("DDDI"));
//		LogUtils.d(TAG, new FindPermutation().findPermutation("DDIIDI"));
	}
}
