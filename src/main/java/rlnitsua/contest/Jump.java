package rlnitsua.contest;

import java.util.Arrays;

public class Jump {
    public int minSideJumps(int[] obstacles) {
        if (obstacles.length <= 2) {
            return 0;
        }

        int[][] dp = new int[3][obstacles.length];

        // initial
        for (int[] item : dp) {
            Arrays.fill(item, -1);
        }

        dp[0][obstacles.length - 1] = 0;
        dp[1][obstacles.length - 1] = 0;
        dp[2][obstacles.length - 1] = 0;

        for (int j = obstacles.length - 2; j >= 0; j--) {
            // calculate extends
            for (int i = 0; i < 3; i++) {
                // has answer
                if (dp[i][j] != -1) {
                    continue;
                }

                // extend
                if (!hasStone(i, j, obstacles) && !hasStone(i, j + 1, obstacles)) {
                    dp[i][j] = dp[i][j + 1];
                }
            }

            // calcualte another one
            for (int i = 0; i < 3; i++) {
                // has answer
                if (dp[i][j] != -1) {
                    continue;
                }

                // another one
                for (int k = 0; k < 3; k++) {
                    if (!hasStone(k, j, obstacles) && i != k) {
                        dp[i][j] = dp[k][j] + 1;
                    }
                }
            }
        }

        return dp[1][0];
    }

    private boolean hasStone(int i, int j, int[] obstacles) {
        if (j == 0 || j == obstacles.length - 1) {
            return false;
        }
        return (obstacles[j] - 1) == i;
    }
}
