package rlnitsua.string;

import rlnitsua.utils.log.LogUtils;

public class OutputContestMatches {
    private static final String TAG = "OutputContestMatches";

    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final String COMMA = ",";

    public String findContestMatch(int n) {
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = String.valueOf(i + 1);
        }
        return getStr(strArr, n);
    }

    private String getStr(String[] strArr, int len) {
        // base recursion
        if (len == 2) {
            return getMatchStr(strArr[0], strArr[1]);
        } else {
            for (int i = 0; i < (len >> 1); i++) {
                int sum = len - 1;
                strArr[i] = getMatchStr(strArr[i], strArr[sum - i]);
            }
            return getStr(strArr, (len >> 1));
        }
    }

    private String getMatchStr(String str1, String str2) {
        return LEFT_BRACKET + str1 + COMMA + str2 + RIGHT_BRACKET;
    }

    public static void main(String[] args) {
//		LogUtils.d(TAG, new OutputContestMatches().findContestMatch(2));
//		LogUtils.d(TAG, new OutputContestMatches().findContestMatch(4));
        LogUtils.d(TAG, new OutputContestMatches().findContestMatch(8));
    }
}
