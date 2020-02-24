package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class NonDecreasingArray {
	private static final String TAG = "NonDecreasingArray";
	
	public boolean checkPossibility(int[] nums) {
		for (int i = 0 ; i < nums.length; i++) {
			if (isIncreasing(nums, i)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isIncreasing(int[] nums, int index) {
		if (nums.length == 1) {
			return true;
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (i == index) {
				continue;
			}
			if ((i + 1) == index) {
				if ((i + 1) == nums.length - 1) {
					continue;
				} else {
					if (nums[i] > nums[i + 2]) {
						return false;
					}
				}
			} else {
				if (nums[i] > nums[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 2, 3};
//		int[] nums = {4, 2, 1};
//		int[] nums = {3, 4, 2, 3};
		LogUtils.d(TAG, new NonDecreasingArray().checkPossibility(nums));
	}
}
