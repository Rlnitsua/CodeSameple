package lizbyu.contest;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;

public class MinimumAbsoluteDifference {
	private static final String TAG = "MinimumAbsoluteDifference";
	
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		// sort
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		// find minimum absolute diff
		int minimum = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			minimum = Math.min(minimum, arr[i + 1] - arr[i]);
		}
		// find res
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == minimum) {
				List<Integer> item = new ArrayList<>();
				item.add(arr[i]);
				item.add(arr[i + 1]);
				res.add(item);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		MinimumAbsoluteDifference difference = new MinimumAbsoluteDifference();
		LogUtils.d(TAG, difference.minimumAbsDifference(new int[] {4,2,1,3}));
		LogUtils.d(TAG, difference.minimumAbsDifference(new int[] {1,3,6,10,15}));
		LogUtils.d(TAG, difference.minimumAbsDifference(new int[] {3,8,-10,23,19,-4,-14,27}));
	}
}
