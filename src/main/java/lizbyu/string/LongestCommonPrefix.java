package lizbyu.string;

import lizbyu.utils.log.LogUtils;

public class LongestCommonPrefix {
    private static final String TAG = "LongestCommonPrefix";

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();

        boolean errorPrefix = false;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length()) {
                    errorPrefix = true;
                    break;
                }

                if (ch != str.charAt(i)) {
                    errorPrefix = true;
                    break;
                } else {
                    errorPrefix = false;
                }
            }
            if (!errorPrefix) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
//		String[] strs = {"abac", "abfac", "abac", "abac", "abac"};
        String[] strs = {"aa", "a"};
        LogUtils.d(TAG, new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
