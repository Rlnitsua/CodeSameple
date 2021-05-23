package rlnitsua.contest;

public class CanReach {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[s.length()];
        dp[dp.length - 1] = true;
        drawDp(dp, s, minJump, maxJump, s.length() - 1, s.length() - 1);
        return dp[0];
    }

    private void drawDp(boolean[] dp, String s, int minJump, int maxJump, int startIndex, int endIndex) {
        int nextStartIndex = startIndex - maxJump;
        int nextEndIndex = endIndex - minJump;
        for (int i = nextEndIndex; i >= nextStartIndex; i--) {
            if (i < 0) {
                return;
            }
            if (s.charAt(i) == '0') {
                drawInner(i, minJump, maxJump, s, dp);
            }
        }
        drawDp(dp, s, minJump, maxJump, nextStartIndex, nextEndIndex);
    }

    private void drawInner(int i, int minJump, int maxJump, String s, boolean[] dp) {
        for (int j = i + minJump; j <= i + maxJump && j < s.length() ; j++) {
            if (dp[j]) {
                dp[i] = true;
                return;
            }
        }
    }
}
