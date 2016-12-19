package org.uncle.lee.math;

import org.uncle.lee.log.LogUtils;

public class AddDigits {
	private static final String TAG = "AddDigits";
	
	public int addDigits(int num) {
		// calculate all digit numbers sum
		int sum = 0;
		while(num >= 1){
			sum += num%10;
			num /= 10;
		}
		
		// if sum is bigger than 10, use it again
		if(sum >= 10){
			return addDigits(sum);
		}else {
			return sum;
		}
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "38 = " + new AddDigits().addDigits(38));
	}
}
