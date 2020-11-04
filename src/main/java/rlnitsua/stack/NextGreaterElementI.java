package rlnitsua.stack;

import rlnitsua.utils.log.LogUtils;

public class NextGreaterElementI {
    public static final String TAG = "NextGreaterElementI";

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null) {
            return null;
        }

        for (int i = 0; i < findNums.length; i++) {
            int index = -1;
            for (int j = 0; j < nums.length; j++) {
                if (findNums[i] == nums[j]) {
                    index = j;
                    break;
                }
            }

            boolean findResult = false;
            for (int j = (index + 1); j < nums.length; j++) {
                if (findNums[i] < nums[j]) {
                    findResult = true;
                    findNums[i] = nums[j];
                    break;
                }
            }

            if (!findResult) {
                findNums[i] = -1;
            }
        }
        return findNums;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        LogUtils.d(TAG, new NextGreaterElementI().nextGreaterElement(nums1, nums2));
    }
}
