package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class ShortestWordDistance {
    private static final String TAG = "ShortestWordDistance";

    //error sample a b a c | a | c
    @Deprecated
    public int shortestDistance0(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1Index == -1) {
                    word1Index = i;
                } else if (Math.abs(i - word2Index) <= Math.abs(word1Index - word2Index)) {
                    word1Index = i;
                }
            } else if (words[i].equals(word2)) {
                if (word2Index == -1) {
                    word2Index = i;
                } else if (Math.abs(i - word1Index) <= Math.abs(word2Index - word1Index)) {
                    word2Index = i;
                }
            }
        }

        return Math.abs(word1Index - word2Index);
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Index = -1, word2Index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
            } else if (words[i].equals(word2)) {
                word2Index = i;
            }

            if (word1Index != -1 && word2Index != -1) {
                min = Math.min(min, Math.abs(word1Index - word2Index));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b"};
//		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "a", word2 = "b";
//		String word1 = "coding", word2 = "practice";
//		String word1 = "makes", word2 = "coding";
        for (int i = 0; i < 50; i++) {
            LogUtils.d(TAG, new ShortestWordDistance().shortestDistance(words, word1, word2));
        }
    }
}
