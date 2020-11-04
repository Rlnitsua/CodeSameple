package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

public class ShortestWordDistanceIII {
    private static final String TAG = "ShortestWordDistanceIII";

    // o(n)
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return shortestSameWordDistance(words, word1);
        } else {
            return shortestDifWordDistance(words, word1, word2);
        }
    }

    private int shortestSameWordDistance(String[] words, String word) {
        int minDif = Integer.MAX_VALUE;
        int lastIndex = -1;
        // o(n)
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                if (lastIndex == -1) {
                    lastIndex = i;
                } else {
                    minDif = Math.min(minDif, Math.abs(lastIndex - i));
                    lastIndex = i;
                }
            }
        }
        return minDif;
    }

    private int shortestDifWordDistance(String[] words, String word1,
                                        String word2) {
        int minDif = Integer.MAX_VALUE;
        int word1Index = -1;
        int word2Index = -1;

        // o(n)
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word2Index == -1) {
                    word1Index = i;
                } else {
                    minDif = Math.min(minDif, Math.abs(word2Index - i));
                    word1Index = i;
                }
            } else if (words[i].equals(word2)) {
                if (word1Index == -1) {
                    word2Index = i;
                } else {
                    minDif = Math.min(minDif, Math.abs(word1Index - i));
                    word2Index = i;
                }
            }
        }

        return minDif;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        ShortestWordDistanceIII shortestWordDistance = new ShortestWordDistanceIII();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        LogUtils.d(TAG, shortestWordDistance.shortestWordDistance(words, "makes", "coding"));
        LogUtils.d(TAG, shortestWordDistance.shortestWordDistance(words, "makes", "makes"));
    }
}
