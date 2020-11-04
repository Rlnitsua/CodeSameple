package rlnitsua.dynamic;

public class Spiderman {
    public long shuttleInBuildings(int[] heights, int k, int x, int y) {
        long[] dp = new long[heights.length];
        dp[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= Math.max(0, i - k); j--) {
                if (heights[i] > heights[j]) {
                    boolean isMax = true;
                    for (int n = j; n < i; n++) {
                        if (heights[n] > heights[j]) {
                            isMax = false;
                            break;
                        }
                    }
                    if (isMax) {
                        dp[i] = Math.min(dp[i], dp[j] + x);
                    }
                }
            }
            for (int j = i - 1; j >= Math.max(0, i - 2); j--) {
                dp[i] = Math.min(dp[i], dp[j] + y);
            }
        }
        return dp[heights.length - 1];
    }
}
