package rlnitsua.dynamic;

public class LongestCommonSubstring {
    public String LCS (String str1, String str2) {
        int longest = -1;
        int end = 0;
        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < str2.length(); j++) {
            if (str2.charAt(j) == str1.charAt(0)) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > longest) {
                        longest = dp[i][j];
                        end = i;
                    }
                }
            }
        }

        return str1.substring(end + 1 - longest, end + 1);
    }
}
