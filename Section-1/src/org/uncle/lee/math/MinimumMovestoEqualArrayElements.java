package org.uncle.lee.math;

import org.uncle.lee.log.LogUtils;

public class MinimumMovestoEqualArrayElements {
	private static final String TAG = "MinimumMovestoEqualArrayElements";
	
	public int minMoves(int[] nums) {
		int sum = 0;
		int minNum = nums[0];
		for(int num : nums){
			minNum = minNum > num ? num : minNum;
			sum += num;
		}
		return sum - (minNum * nums.length);
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		LogUtils.d(TAG, new MinimumMovestoEqualArrayElements().minMoves(nums));
	}
}
