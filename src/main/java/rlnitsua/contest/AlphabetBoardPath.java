package rlnitsua.contest;

import rlnitsua.utils.log.LogUtils;

public class AlphabetBoardPath {
    private static final String TAG = "AlphabetBoardPath";

    public String alphabetBoardPath(String target) {
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < target.length(); i++) {
            char pre;
            if (i == 0) {
                pre = 'a';
            } else {
                pre = target.charAt(i - 1);
            }
            sb.append(calculatePath(pre, target.charAt(i), board));
        }

        return sb.toString();
    }

    private String calculatePath(char pre, char next, String[] board) {
        StringBuffer sb = new StringBuffer();

        int preRow = findRow(pre, board);
        int nextRow = findRow(next, board);
        int preColumn = findColumn(pre, board[preRow]);
        int nextColumn = findColumn(next, board[nextRow]);

        if (nextRow != board.length - 1) {
            sb.append(rowPath(preRow, nextRow));
            sb.append(columnTag(preColumn, nextColumn));
        } else {
            sb.append(columnTag(preColumn, nextColumn));
            sb.append(rowPath(preRow, nextRow));
        }

        sb.append("!");

        return sb.toString();
    }

    private String rowPath(int preRow, int nextRow) {
        StringBuffer sb = new StringBuffer();
        int rowCount = Math.abs(preRow - nextRow);
        String rowTag = "";
        if (preRow - nextRow < 0) {
            rowTag = "D";
        } else if (preRow - nextRow > 0) {
            rowTag = "U";
        }
        for (int i = 0; i < rowCount; i++) {
            sb.append(rowTag);
        }
        return sb.toString();
    }

    private String columnTag(int preColumn, int nextColumn) {
        StringBuffer sb = new StringBuffer();
        int columnCount = Math.abs(preColumn - nextColumn);
        String columnTag = "";
        if (preColumn - nextColumn < 0) {
            columnTag = "R";
        } else if (preColumn - nextColumn > 0) {
            columnTag = "L";
        }
        for (int i = 0; i < columnCount; i++) {
            sb.append(columnTag);
        }

        return sb.toString();
    }

    private int findRow(char target, String[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i].contains(String.valueOf(target))) {
                return i;
            }
        }
        return -1;
    }

    private int findColumn(char target, String string) {
        for (int i = 0; i < string.length(); i++) {
            if (target == string.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AlphabetBoardPath alphabetBoardPath = new AlphabetBoardPath();
//		LogUtils.d(TAG, alphabetBoardPath.alphabetBoardPath("leet"));
//		LogUtils.d(TAG, alphabetBoardPath.alphabetBoardPath("code"));
        LogUtils.d(TAG, alphabetBoardPath.alphabetBoardPath("zdz"));
        LogUtils.d(TAG, alphabetBoardPath.alphabetBoardPath("zb"));
    }
}
