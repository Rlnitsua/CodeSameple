package rlnitsua.stack;

import rlnitsua.utils.log.LogUtils;

import java.util.Arrays;

public class NextGreaterElementII {
    private static final String TAG = "NextGreaterElementII";

    public int[] nextGreaterElements(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < res.length; i++) {
            boolean isBigger = false;
            for (int j = i; j < res.length; j++) {
                if (nums[j] > nums[i]) {
                    isBigger = true;
                    res[i] = nums[j];
                    break;
                }
            }
            if (!isBigger) {
                for (int j = 0; j <= i; j++) {
                    if (nums[j] > nums[i]) {
                        isBigger = true;
                        res[i] = nums[j];
                        break;
                    }
                }
            }
            if (!isBigger) {
                res[i] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        int[] nums = new int[]{5, 4, 3, 2, 1};
        LogUtils.d(TAG, new NextGreaterElementII().nextGreaterElements(nums));
    }
}
