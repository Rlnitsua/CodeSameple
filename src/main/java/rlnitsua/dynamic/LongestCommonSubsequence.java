package rlnitsua.dynamic;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        boolean isSame = false;
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0) || isSame) {
                isSame = true;
                dp[i][0] = 1;
            }
        }

        isSame = false;
        for (int j = 0; j < text2.length(); j++) {
            if (text2.charAt(j) == text1.charAt(0) || isSame) {
                isSame = true;
                dp[0][j] = 1;
            }
        }


        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
