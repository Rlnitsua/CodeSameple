package rlnitsua.string;

import rlnitsua.utils.log.LogUtils;

public class JudgeRouteCircle {
    private static final String TAG = "JudgeRouteCircle";

    public boolean judgeCircle(String moves) {
        if (moves == null) {
            return false;
        }

        int upCount = 0;
        int leftCount = 0;

        char[] arr = moves.toCharArray();

        for (char ch : arr) {
            switch (ch) {
                case 'U':
                    upCount++;
                    break;
                case 'D':
                    upCount--;
                    break;
                case 'L':
                    leftCount++;
                    break;
                case 'R':
                    leftCount--;
                    break;
            }
        }

        if (upCount == 0 && leftCount == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String msg = "DURDLDRRLL";
        LogUtils.d(TAG, new JudgeRouteCircle().judgeCircle(msg));
    }
}
