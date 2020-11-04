package rlnitsua.array;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int res = 0;

        for (String word : words) {
            if (isExtension(S, word)) {
                res++;
            }
        }

        return res;
    }

    private boolean isExtension(String s, String word) {
        int sIndex = 0;
        int wordIndex = 0;

        while (sIndex < s.length() && wordIndex < word.length()) {
            char target = s.charAt(sIndex);
            int sCount = 0;
            int wordCount = 0;

            if (word.charAt(wordIndex) != target) {
                return false;
            }

            while (sIndex < s.length()) {
                if (s.charAt(sIndex) != target) {
                    break;
                } else {
                    sCount++;
                    sIndex++;
                }
            }

            while (wordIndex < word.length()) {
                if (word.charAt(wordIndex) != target) {
                    break;
                } else {
                    wordCount++;
                    wordIndex++;
                }
            }

            if (sCount < wordCount) {
                return false;
            } else if (sCount > wordCount) {
                if (sCount < 3) {
                    return false;
                }
            }
        }

        return sIndex == s.length() && wordIndex == word.length();
    }
}
