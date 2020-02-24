package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class SingleElementinaSortedArray {
	private static final String TAG = "SingleElementinaSortedArray";
	
	public int singleNonDuplicate(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i + 1]) {
				i++;
			} else {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,3,3,4,4,8,8};
		LogUtils.d(TAG, new SingleElementinaSortedArray().singleNonDuplicate(arr));
	}
}
