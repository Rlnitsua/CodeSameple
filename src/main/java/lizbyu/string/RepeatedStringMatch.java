package lizbyu.string;

import lizbyu.utils.log.LogUtils;

public class RepeatedStringMatch {
    private static final String TAG = "RepeatedStringMatch";

    public int repeatedStringMatch(String A, String B) {
        int res = -1;
        boolean hasSub = false;

        int maxLength = B.length() / A.length();

        for (int i = maxLength; i <= maxLength + 2; i++) {
            hasSub = getATimes(A, i).contains(B);
            if (hasSub == true) {
                res = i;
                break;
            }
        }
        return res == 0 ? 1 : res;
    }

    private String getATimes(String a, int time) {
        String res = "";
        for (int i = 0; i < time; i++) {
            res += a;
        }
        return res;
    }

    public static void main(String[] args) {
        RepeatedStringMatch demo = new RepeatedStringMatch();
        LogUtils.d(TAG, demo.repeatedStringMatch("abcd", "cdabcdab"));
        LogUtils.d(TAG, demo.repeatedStringMatch("aa", "a"));
        LogUtils.d(TAG, demo.repeatedStringMatch("bb", "bbbbbbb"));
    }
}
