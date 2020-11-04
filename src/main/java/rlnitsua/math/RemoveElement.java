package rlnitsua.math;

import rlnitsua.utils.log.LogUtils;

public class RemoveElement {
    private static final String TAG = "RemoveElement";

    public int removeElement(int[] nums, int val) {
        int realIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != val) {
                nums[realIndex] = nums[index];
                realIndex++;
            }
        }
        return realIndex;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new RemoveElement().removeElement(nums, 3));
    }
}
