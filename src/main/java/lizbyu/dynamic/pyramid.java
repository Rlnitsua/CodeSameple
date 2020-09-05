package lizbyu.dynamic;

import java.util.List;

public class pyramid {
    public int pyramid(int n, List<Integer> k) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    dp[i][j] = (int) ((dp[i][j - 1] + dp[i - 1][j - 1]) % (Math.pow(10, 9) + 7));
                } else if (j != 0) {
                    dp[i][j] = (int) ((dp[i][j - 1] + dp[i - 1][j - 1] + dp[i - 1][j]) % (Math.pow(10, 9) + 7));
                }
            }
        }

        int res = 0;

        for (int num : k) {
            res += (dp[n - num][n - num] % (Math.pow(10, 9) + 7));
        }

        return res;
    }
}
