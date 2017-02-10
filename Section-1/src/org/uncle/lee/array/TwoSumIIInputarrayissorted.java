package org.uncle.lee.array;

import org.uncle.lee.log.LogUtils;

public class TwoSumIIInputarrayissorted {
	private static final String TAG = "TwoSumIIInputarrayissorted";

	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			int existRes = existRes(numbers, i + 1, target - numbers[i]);
			if (existRes != -1) {
				res[0] = i + 1;
				res[1] = existRes + 1;
				return res;
			}
		}

		return res;
	}

	private int existRes(int[] numbers, int index, int target) {
		int front = index;
		int end = numbers.length - 1;

		while (front <= end) {
			int mid = (front + end) >> 1;
			if (numbers[mid] > target) {
				end = mid - 1;
			} else if (numbers[mid] < target) {
				front = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
//		int[] numbers = { 2, 7, 11, 15 };
//		int target = 9;
//		LogUtils.d(TAG,
//				new TwoSumIIInputarrayissorted().twoSum(numbers, target));
//
//		int[] numbers1 = { 2, 3, 4 };
//		int target1 = 6;
//		LogUtils.d(TAG,
//				new TwoSumIIInputarrayissorted().twoSum(numbers1, target1));
		
		int[] numbers2 = {1,2,3,4,4,9,56,90};
		int target2 = 8;
		LogUtils.d(TAG,
				new TwoSumIIInputarrayissorted().twoSum(numbers2, target2));
	}
}
