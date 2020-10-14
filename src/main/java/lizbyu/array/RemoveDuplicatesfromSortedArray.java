package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class RemoveDuplicatesfromSortedArray {
    private static final String TAG = "RemoveDuplicatesfromSortedArray";

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slowIndex = 0;
        int fastIndex = 1;
        int sameCount = 0;
        for (int index = 0; index < (nums.length - 1) && fastIndex < nums.length; index++) {
            while (nums[slowIndex] == nums[fastIndex]) {
                fastIndex++;
                sameCount++;
                if (fastIndex == nums.length) {
                    return nums.length - sameCount;
                }
            }
            nums[index + 1] = nums[fastIndex];
            slowIndex = fastIndex;
            fastIndex++;
        }
        return nums.length - sameCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        int[] nums1 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4};
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        int[] nums3 = {1, 1};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new RemoveDuplicatesfromSortedArray().removeDuplicates(nums));
        LogUtils.d(TAG, new RemoveDuplicatesfromSortedArray().removeDuplicates(nums1));
        LogUtils.d(TAG, nums1);
        LogUtils.d(TAG, new RemoveDuplicatesfromSortedArray().removeDuplicates(nums2));
        LogUtils.d(TAG, new RemoveDuplicatesfromSortedArray().removeDuplicates(nums3));
    }
}
