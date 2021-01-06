package rlnitsua.hash;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;

        boolean[] allowedArr = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            allowedArr[ch - 'a'] = true;
        }

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!allowedArr[word.charAt(i) - 'a']) {
                    break;
                }
                if (i == word.length() - 1) {
                    res++;
                }
            }
        }

        return res;
    }

}
