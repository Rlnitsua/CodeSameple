package rlnitsua.dynamic;

public class MinimumDeletionstoMakeStringBalanced {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length()];
        int bCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (bCount == 0) {
                    dp[i] = 0;
                } else {
                    dp[i] = Math.min(bCount, dp[i - 1] + 1);
                }
            } else {
                bCount++;
                dp[i] = (i == 0) ? 0 : dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }
}
