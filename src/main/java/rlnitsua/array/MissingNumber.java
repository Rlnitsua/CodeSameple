package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

public class MissingNumber {
    private static final String TAG = "MissingNumber";

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int missingNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            missingNumber += i;
            missingNumber -= nums[i];
        }
        return missingNumber + nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        int[] nums1 = {45, 35, 38, 13, 12, 23, 48, 15, 44, 21, 43, 26, 6, 37,
                1, 19, 22, 3, 11, 32, 4, 16, 28, 49, 29, 36, 33, 8, 9, 39, 46,
                17, 41, 7, 2, 5, 27, 20, 40, 34, 30, 25, 47, 0, 31, 42, 24, 10,
                14};
        LogUtils.d(TAG, new MissingNumber().missingNumber(nums));
        LogUtils.d(TAG, new MissingNumber().missingNumber(nums1));
    }
}
