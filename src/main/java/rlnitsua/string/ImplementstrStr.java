package rlnitsua.string;

import rlnitsua.utils.log.LogUtils;

public class ImplementstrStr {
    private static final String TAG = "ImplementstrStr";

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null ||
                !haystack.contains(needle)) {
            return -1;
        }

        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0) {
            return -1;
        } else if (needle.length() == 0) {
            return 0;
        }

        return calcuIndex(haystack, needle, 0, 0);
    }

    private int calcuIndex(String haystack, String needle, int haystackIndex, int needleIndex) {
        int hIndex = haystackIndex;
        int nIndex = needleIndex;
        int sameCount = 0;

        while (hIndex < haystack.length() &&
                nIndex < needle.length()) {
            if (haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                hIndex++;
                nIndex++;
                sameCount++;
            } else {
                sameCount = 0;
                return calcuIndex(haystack, needle, haystackIndex + 1, 0);
            }

            if (sameCount == needle.length()) {
                return hIndex - nIndex;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new ImplementstrStr().strStr("abcddabce", "abce"));
        LogUtils.d(TAG, new ImplementstrStr().strStr("abcddabce", "cd"));
    }
}
