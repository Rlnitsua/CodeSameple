package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class MergeSortedArray {
	private static final String TAG = "MergeSortedArray";
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		boolean isBiggest = false;
		int nums1Index = 0;
		
		for(int nums2Index = 0; nums2Index < n; nums2Index++) {
			// find correct index to index
			for(int i = nums1Index; i < m + nums2Index; i++) {
				if(nums1[i] >= nums2[nums2Index]) {
					isBiggest = false;
					nums1Index = i;
					break;
				} else {
					isBiggest = true;
				}
			}
			if(isBiggest) {
				nums1Index = m + nums2Index;
				isBiggest = false;
			}
			
			// insert this value
			for(int i = m + nums2Index; i >= nums1Index + 1; i--) {
				nums1[i] = nums1[i - 1];
			}
			nums1[nums1Index] = nums2[nums2Index];
		}
	}

	public static void main(String[] args) {
/*		int[] nums1 = {1, 3, 4, 5, 7, 0, 0, 0, 0};
		int[] nums2 = {1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0};
		new MergeSortedArray().merge(nums1, 5, nums2, 4);*/
		
		int[] nums1 = {1, 3, 4, 5, 7, 0, 0, 0, 0};
		int[] nums2 = {2, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0};
		new MergeSortedArray().merge(nums1, 1, nums2, 1);
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, nums1);
		LogUtils.d(TAG, nums2);
	}
}
