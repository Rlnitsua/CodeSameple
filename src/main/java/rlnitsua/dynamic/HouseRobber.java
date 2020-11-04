package rlnitsua.dynamic;

import rlnitsua.utils.log.LogUtils;

public class HouseRobber {
    private static final String TAG = "HouseRobber";

    public int rob(int[] nums) {
        int rob[] = new int[nums.length + 1];
        int unRob[] = new int[nums.length + 1];

        rob[0] = 0;
        unRob[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            unRob[i] = Math.max(rob[i - 1], unRob[i - 1]);
            rob[i] = unRob[i - 1] + nums[i - 1];
        }

        return Math.max(rob[nums.length], unRob[nums.length]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5, 6};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new HouseRobber().rob(nums));
    }
}
