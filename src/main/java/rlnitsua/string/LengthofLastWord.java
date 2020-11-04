package rlnitsua.string;

import rlnitsua.utils.log.LogUtils;

public class LengthofLastWord {
    private static final String TAG = "LengthofLastWord";

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            String[] split = s.split(" ");
            return (split == null || split.length == 0) ?
                    0 : split[split.length - 1].length();
        }
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new LengthofLastWord().lengthOfLastWord(" "));
        LogUtils.d(TAG, new LengthofLastWord().lengthOfLastWord("a"));
    }
}
