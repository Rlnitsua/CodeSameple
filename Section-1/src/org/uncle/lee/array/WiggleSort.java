package org.uncle.lee.array;

import org.uncle.lee.log.LogUtils;

public class WiggleSort {
	private static final String TAG = "WiggleSort";
	
	public void wiggleSort(int[] nums) {
		sortArray(nums);
		
		int[] array1 = new int[(nums.length + 1) >> 1];
		System.arraycopy(nums, 0, array1, 0, (nums.length + 1) >> 1);
		int[] array2 = new int[nums.length - ((nums.length + 1) >> 1)];
		System.arraycopy(nums, (nums.length + 1) >> 1, array2, 0, nums.length - ((nums.length + 1) >> 1));
		
		combineArray(nums, array1, array2);
	}

	private void sortArray(int[] nums) {
		for(int i = 0; i < nums.length; i++){
			boolean isSorted = true;
			for(int j = 0; j < nums.length - 1 - i; j++){
				if(nums[j] > nums[j + 1]){
					swap(nums, j, j + 1);
					isSorted = false;
				}
			}
			if(isSorted){
				break;
			}
		}
	}
	
	private void swap(int[] nums, int j, int i) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	private void combineArray(int[] nums, int[] array1, int[] array2) {
		for(int i = 0; i < nums.length; i++){
			if(i % 2 == 0){
				nums[i] = array1[(i + 1) >> 1];
			} else {
				nums[i] = array2[i >> 1];
			}
		}
	}
	
	public static void main(String[] args) {
//		int[] nums = {1, 2, 3, 4, 5, 6};
		int[] nums1 = {3, 5, 2, 1, 6, 4};
		new WiggleSort().wiggleSort(nums1);
		LogUtils.d(TAG, nums1);
	}
}
