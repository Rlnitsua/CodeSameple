package rlnitsua.dynamic;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";

        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                boolean isSame = s.charAt(i) == s.charAt(j);

                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = isSame;
                } else {
                    dp[i][j] = isSame && dp[i + 1][j - 1];
                }

                if (dp[i][j] && l + 1 > res.length()) {
                    res = s.substring(i, i + l + 1);
                }
            }
        }
        return res;
    }
}
