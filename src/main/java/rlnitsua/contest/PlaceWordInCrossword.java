package rlnitsua.contest;

import java.util.ArrayList;
import java.util.List;

public class PlaceWordInCrossword {
    public boolean placeWordInCrossword(char[][] board, String word) {
        List<String> wordList = calculateWordList(board, word.length());
        for (String realWord : wordList) {
            if (isValid(realWord, word)) {
                return true;
            }
        }
        return false;
    }

    private List<String> calculateWordList(char[][] board, int len) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char[] line : board) {
            for (int index = 0; index < board[0].length; index++) {
                if (line[index] == '#') {
                    if (sb.length() != 0) {
                        if (sb.length() == len) {
                            list.add(sb.toString());
                        }
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(line[index]);
                }
            }
            if (sb.length() != 0) {
                if (sb.length() == len) {
                    list.add(sb.toString());
                }
                sb = new StringBuilder();
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            for (char[] line : board) {
                if (line[j] == '#') {
                    if (sb.length() != 0) {
                        if (sb.length() == len) {
                            list.add(sb.toString());
                        }
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(line[j]);
                }
            }
            if (sb.length() != 0) {
                if (sb.length() == len) {
                    list.add(sb.toString());
                }
                sb = new StringBuilder();
            }
        }
        return list;
    }

    private boolean isValid(String realWord, String word) {
        boolean isValid = true;
        boolean isReverseValid = true;
        for (int i = 0; i < realWord.length(); i++) {
            if (realWord.charAt(i) != ' ' && realWord.charAt(i) != word.charAt(i)) {
                isValid = false;
                break;
            }
        }
        for (int i = 0; i < realWord.length(); i++) {
            char targetCh = realWord.charAt(realWord.length() - 1 - i);
            if (targetCh != ' ' && targetCh != word.charAt(i)) {
                isReverseValid = false;
                break;
            }
        }

        return isValid || isReverseValid;
    }
}
