package rlnitsua.contest;

import rlnitsua.utils.log.LogUtils;

import java.util.Stack;

public class MaximumNestingDepthofTwoValidParenthesesStrings {
    private static final String TAG = "MaximumNestingDepthofTwoValidParenthesesStrings";

    public int[] maxDepthAfterSplit(String seq) {
        boolean isRes = false;
        int[] resIndex = new int[]{0, 1};

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                if (i < seq.length() - 1 && seq.charAt(i + 1) == '(') {
                    isRes = true;
                    resIndex[0] = i;
                }
            } else {
                stack.pop();
                if (isRes && stack.isEmpty()) {
                    resIndex[1] = i;
                    break;
                }
            }
        }

        int[] res = new int[seq.length()];
        for (int i = 0; i < res.length; i++) {
            if (i == resIndex[0] || i == resIndex[1]) {
                res[i] = 0;
            } else {
                res[i] = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumNestingDepthofTwoValidParenthesesStrings m = new MaximumNestingDepthofTwoValidParenthesesStrings();
        LogUtils.d(TAG, m.maxDepthAfterSplit("(()())"));
        LogUtils.d(TAG, m.maxDepthAfterSplit("()(())()"));
        LogUtils.d(TAG, m.maxDepthAfterSplit("()()"));
        LogUtils.d(TAG, m.maxDepthAfterSplit("()"));
    }
}
