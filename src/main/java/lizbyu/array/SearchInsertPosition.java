package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class SearchInsertPosition {
    private static final String TAG = "SearchInsertPosition";

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        } else if (nums.length == 1 && target == nums[nums.length - 1]) {
            return 0;
        } else {
            return search(nums, target, 0, nums.length - 1);
        }
    }

    private int search(int[] nums, int target, int low, int high) {
        int mid = 0;

        while (low < high) {
            mid = (low + high) >> 1;

            if (target < nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low - 1] == target ? low - 1 : low;
    }

    public static void main(String[] args) {
/*		int[] nums = {1,3,5,6};
		LogUtils.d(TAG, new SearchInsertPosition().searchInsert(nums, 5));
		LogUtils.d(TAG, new SearchInsertPosition().searchInsert(nums, 2));
		LogUtils.d(TAG, new SearchInsertPosition().searchInsert(nums, 7));
		LogUtils.d(TAG, new SearchInsertPosition().searchInsert(nums, 0));
		
		int[] nums1 = {1, 3};
		LogUtils.d(TAG, new SearchInsertPosition().searchInsert(nums1, 2));*/

        int[] nums2 = {1};
        LogUtils.d(TAG, new SearchInsertPosition().searchInsert(nums2, 1));
    }
}
