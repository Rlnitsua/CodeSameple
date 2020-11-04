package rlnitsua.string;

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] score = calculateScore(order);

        for (int i = 0; i < words.length - 1; i++) {
            if (isBigger(words[i], words[i + 1], score)) {
                return false;
            }
        }
        return true;
    }

    private int[] calculateScore(String order) {
        int[] score = new int[26];
        for (int i = 0; i < order.length(); i++) {
            score[order.charAt(i) - 97] = i;
        }
        return score;
    }

    private boolean isBigger(String s0, String s1, int[] order) {
        int index = 0;

        while (index < s0.length() && index < s1.length()) {
            if (order[s0.charAt(index) - 97] < order[s1.charAt(index) - 97]) {
                return false;
            } else if (order[s0.charAt(index) - 97] > order[s1.charAt(index) - 97]) {
                return true;
            } else {
                index++;
            }
        }

        return s0.length() > s1.length();
    }
}
