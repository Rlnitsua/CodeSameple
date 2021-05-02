package rlnitsua.contest;

public class MaxLenBeautifulStr {
    public int longestBeautifulSubstring(String word) {
        int maxLen = 0;
        char[] chArr = new char[]{'a', 'e', 'i', 'o', 'u'};
        int index = 0;
        int currentLen = 0;
        boolean isBeautiful = false;

        for (char ch : word.toCharArray()) {
            if (isBeautiful) {
                if (ch == 'u') {
                    currentLen++;
                } else {
                    maxLen = Math.max(maxLen, currentLen);
                    index = 0;
                    currentLen = 0;
                    if (ch == 'a') {
                        index++;
                        currentLen++;
                    }
                    isBeautiful = false;
                }
                continue;
            }

            if (ch == chArr[index]) {
                if (currentLen != 0 && ch == 'u') {
                    isBeautiful = true;
                }
                index++;
                currentLen++;
            } else if (index != 0 && ch == chArr[index - 1]) {
                currentLen++;
            } else {
                index = 0;
                currentLen = 0;
                if (ch == 'a') {
                    index++;
                    currentLen++;
                }
            }
        }

        if (isBeautiful) {
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}
