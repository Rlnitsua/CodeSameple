package rlnitsua.contest;

public class MaxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        dp[0][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + nums[i], Math.max(nums[i], dp[i - 1][0]));
            dp[i][1] = Math.max(dp[i - 1][0] - nums[i], dp[i - 1][1]);
        }
        return dp[nums.length - 1][0];
    }
}
