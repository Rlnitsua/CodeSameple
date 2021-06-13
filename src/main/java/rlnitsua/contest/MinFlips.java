package rlnitsua.contest;

public class MinFlips {
    public int minFlips(String s) {
        int[] dp = new int[s.length() - 1];
        int origin = calculateFlip(s);
        int res = origin;

        for (int i = 0; i < dp.length - 1; i++) {
            char last = (i == 0) ? s.charAt(s.length() - 1)
                    : s.charAt(i - 1);
            int lastDp = (i == 0) ? origin : dp[i - 1];
            int lastCount;

            char targetLast = ((s.length() - 1 % 2) == 0) ?
                    s.charAt(i + 1) : ((s.charAt(i + 1) == '0') ? '1' : '0');

            if (last == targetLast) {
                lastCount = (s.charAt(i) == last) ? lastDp + 1 : lastDp;
            } else {
                lastCount = (s.charAt(i) == last) ? lastDp : lastDp + 1;
            }

            if (s.charAt(i) != s.charAt(i + 1)) {
                dp[i] = s.length() - 1 - lastDp + lastCount;
            } else {
                dp[i] = lastCount;
            }

            res = Math.min(res, dp[i]);
            if (res == 0) {
                return res;
            }
        }

        return res;
    }

    private int calculateFlip(String s) {
        int count = 0;
        char pre = s.charAt(0);
        int index = 1;

        while (index < s.length()) {
            if (pre == s.charAt(index++)) {
                count++;
            }
            pre = pre == '1' ? '0' : '1';
        }

        return count;
    }
}
