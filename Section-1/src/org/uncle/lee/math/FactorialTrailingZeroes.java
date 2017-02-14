package org.uncle.lee.math;

import org.uncle.lee.log.LogUtils;

public class FactorialTrailingZeroes {
	private static final String TAG = "FactorialTrailingZeroes";
	
	public int trailingZeroes0(int n) {
		if(n == 0){
			return 0;
		}
		
		int factor2Count = 0;
		int factor5Count = 0;
		for(int i = 1; i <= n; i++){
			int num = i;
			while(num % 2 == 0){
				num /= 2;
				factor2Count++;
			}
		}
		
		for(int i = 1; i <= n; i++){
			int num = i;
			while(num % 5 == 0){
				num /= 5;
				factor5Count++;
			}
		}
		
		return Math.min(factor2Count, factor5Count);
	}
	
	public int trailingZeroes(int n) {
		int factor2Count = getFactorCount(n, 2);
		int factor5Count = getFactorCount(n, 5);
		return Math.min(factor2Count, factor5Count);
	}
	
	private int getFactorCount(int num, int target){
		int count = 0;
		while(num / target >= 1){
			count += num / target;
			num /= target;
		}
		return count;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, new FactorialTrailingZeroes().trailingZeroes(26));
		LogUtils.d(TAG, new FactorialTrailingZeroes().trailingZeroes(1808548329));
	}
}
