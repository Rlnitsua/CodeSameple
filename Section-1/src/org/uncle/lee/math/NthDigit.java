package org.uncle.lee.math;

import org.uncle.lee.log.LogUtils;

public class NthDigit {
	private static final String TAG = "NthDigit";
	
	public int findNthDigit(int n) {
		int bit = 0;
		long sum = 0;
		
		while(n > sum) {
			sum += getValue(bit);
			bit++;
		}
		bit--;
		
		if(n - sum + getValue(bit) < bit) {
			int remainNum = (int) ((n - sum + getValue(bit)) % bit);
			return Integer.parseInt(String.valueOf(Math.pow(10, bit - 1)).charAt(remainNum - 1) + "");
		} else {
			int mainNum = (int) ((n - sum + getValue(bit)) / bit);
			int remainNum = (int) ((n - sum + getValue(bit)) % bit);
			
			return remainNum == 0 ? ((int)Math.pow(10, bit - 1) + mainNum - 1) % 10 : 
				Integer.parseInt((String.valueOf(((int)(Math.pow(10, bit - 1)) + mainNum))
						.charAt(remainNum - 1) + ""));
		}
	}
	
	private int getValue(int i){
		return (int) (9 * Math.pow(10, i - 1) * i);
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
//		LogUtils.d(TAG, new NthDigit().findNthDigit(10));
//		LogUtils.d(TAG, new NthDigit().findNthDigit(3));
//		LogUtils.d(TAG, new NthDigit().findNthDigit(13));
//		LogUtils.d(TAG, new NthDigit().findNthDigit(14));
//		LogUtils.d(TAG, new NthDigit().findNthDigit(15));
		LogUtils.d(TAG, new NthDigit().findNthDigit(1000000000));
	}
}
