package lizbyu.string;

import java.util.List;

public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words.size() == 1) {
            return words.get(0).length() == 1;
        }

        int max = Integer.MIN_VALUE;
        for (String word : words) {
            max = Math.max(max, word.length());
        }
        max = Math.max(max, words.size());

        for (int i = 1; i < max; i++) {
            for (int j = 0; j < i; j++) {
                if (getPosition(words, i, j) != getPosition(words, j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private char getPosition(List<String> words, int x, int y) {
        if (x < words.size()) {
            if (y < words.get(x).length()) {
                return words.get(x).charAt(y);
            } else {
                return ' ';
            }
        } else {
            return ' ';
        }
    }
}
