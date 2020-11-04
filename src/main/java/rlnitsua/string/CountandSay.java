package rlnitsua.string;

import rlnitsua.utils.log.LogUtils;

public class CountandSay {
    private static final String TAG = "CountandSay";

    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }

        while (n > 1) {
            res = nextVal(res);
            n--;
        }

        return res;
    }

    private String nextVal(String num) {
        char[] numChArray = num.toCharArray();
        StringBuffer sb = new StringBuffer();

        int count = 1;
        for (int i = 0; i < numChArray.length; i++) {
            if (i != numChArray.length - 1 && numChArray[i] == numChArray[i + 1]) {
                count++;
            } else {
                sb.append(Integer.toString(count) + numChArray[i]);
                count = 1;
            }
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new CountandSay().countAndSay(1));
        LogUtils.d(TAG, new CountandSay().countAndSay(2));
        LogUtils.d(TAG, new CountandSay().countAndSay(3));
        LogUtils.d(TAG, new CountandSay().countAndSay(4));
        LogUtils.d(TAG, new CountandSay().countAndSay(5));
    }

}
