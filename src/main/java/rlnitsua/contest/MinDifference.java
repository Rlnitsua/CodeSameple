package rlnitsua.contest;

public class MinDifference {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            dp[i][i + 1] = nums[i] == nums[i + 1] ?
                    Integer.MAX_VALUE : Math.abs(nums[i] - nums[i + 1]);
        }

        int gap = 2;
        while (gap != nums.length) {
            for (int i = 0; i + gap < nums.length; i++) {
                int j = i + gap;
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
                if (nums[i] != nums[j]) {
                    dp[i][j] = Math.min(dp[i][j], Math.abs(nums[i] - nums[j]));
                }
            }
            gap++;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = dp[queries[i][0]][queries[i][1]];
            res[i] = r == Integer.MAX_VALUE ? -1 : r;
        }
        return res;
    }
}
