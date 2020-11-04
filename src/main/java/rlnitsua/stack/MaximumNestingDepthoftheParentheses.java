package rlnitsua.stack;

public class MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        int max = 0;
        int current = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                current++;
                max = Math.max(current, max);
            } else if (ch == ')') {
                current--;
            }
        }

        return max;
    }
}
