package rlnitsua.divide;

import java.util.Arrays;

public class MinimumDeletionCosttoAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        return minCost(s, cost, 0);
    }

    private int minCost(String s, int[] cost, int index) {
        if (index >= s.length() - 1) {
            return 0;
        }

        int start = 0;
        int end = 0;
        boolean isFirst = true;
        for (int i = index; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (isFirst) {
                    start = i;
                    isFirst = false;
                }
                if (i == s.length() - 2) {
                    end = s.length() - 1;
                }
            } else {
                if (!isFirst) {
                    end = i;
                    break;
                }
            }
        }

        if (isFirst) {
            return 0;
        }

        int res = 0;
        int[] arr = Arrays.copyOfRange(cost, start, end + 1);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            res += arr[i];
        }
        return res + minCost(s, cost, end + 1);
    }
}
