package lizbyu.string;

import lizbyu.utils.log.LogUtils;

public class NumberofSegmentsinaString {
    private static final String TAG = "NumberofSegmentsinaString";

    public int countSegments(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        s = s.trim();

        char[] chArray = s.toCharArray();
        int count = 0;

        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == ' ') {
                count++;
                while (i < chArray.length) {
                    if (chArray[i + 1] == ' ') {
                        i++;
                    } else {
                        break;
                    }
                }
            } else if (chArray[i] == '\n' || chArray[i] == '\t') {
                count++;
            }
        }

        return ++count;
    }

    public static void main(String[] args) {
        // \b  \t  \n  \f  \r  \"  \'  \\
//		String s = ", , , ,        a,    e\bae\fa\nddd\tsss\\wwwww";
//		String s = " a         a    abc ";
        String s = ", , , ,        a, eaefa";
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, s);
        LogUtils.d(TAG, new NumberofSegmentsinaString().countSegments(s));
    }
}
