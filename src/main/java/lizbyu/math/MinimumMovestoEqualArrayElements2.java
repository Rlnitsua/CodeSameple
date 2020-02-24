package lizbyu.math;

import java.util.Arrays;

import lizbyu.utils.log.LogUtils;

public class MinimumMovestoEqualArrayElements2 {
	private static final String TAG = "MinimumMovestoEqualArrayElements2";
	
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		
		int count = 0;
		int i = 0, j = nums.length - 1;
		
		while(i < j){
			count += nums[j] - nums[i];
			i++;
			j--;
		}
		return count;
	}

	public static void main(String[] args) {
//		int[] nums = {1, 2, 3};
//		int[] nums = {1, 1, 2};
		int[] nums = {1, 0, 0, 8, 6};
		LogUtils.d(TAG, new MinimumMovestoEqualArrayElements2().minMoves2(nums));
	}
}
