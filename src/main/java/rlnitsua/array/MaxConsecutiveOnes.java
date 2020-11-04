package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

public class MaxConsecutiveOnes {
    private static final String TAG = "MaxConsecutiveOnes";

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxConsecutive = 0;
        int currentConsecutive = 0;

        for (int num : nums) {
            if (num == 0) {
                if (currentConsecutive > maxConsecutive) {
                    maxConsecutive = currentConsecutive;
                }
                currentConsecutive = 0;
            } else {
                currentConsecutive++;
            }
        }

        if (currentConsecutive > maxConsecutive) {
            maxConsecutive = currentConsecutive;
        }
        currentConsecutive = 0;

        return maxConsecutive;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        LogUtils.d(TAG, new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }
}
