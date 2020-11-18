package rlnitsua.string;


public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int end = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char target = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != target) {
                    return end == 0 ? "" : strs[0].substring(0, end);
                }
            }
            end++;
        }
        return strs[0];
    }
}
