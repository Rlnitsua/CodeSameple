package rlnitsua.design;

import rlnitsua.utils.log.LogUtils;

public class BattleshipsinaBoard {
    private static final String TAG = "BattleshipsinaBoard";

    public int countBattleships(char[][] board) {
        int resCount = 0;
        boolean[][] hasVisitedBoard = new boolean[board.length][board[0].length];

        for (int line = 0; line < board.length; line++) {
            for (int row = 0; row < board[0].length; ) {
                if (hasVisitedBoard[line][row]) {
                    row++;
                    continue;
                }

                if (board[line][row] == 'X') {
                    int shipSize = 0;
                    int rowTemp = row;

                    // count -->
                    while (row < board[0].length && board[line][row] == 'X') {
                        hasVisitedBoard[line][row] = true;
                        row++;
                        shipSize++;
                    }

                    // count down
                    for (int i = rowTemp; i < Math.min(rowTemp + shipSize, board[0].length); i++) {
                        // count next line
                        int lineTemp = line;
                        lineTemp++;

                        while (lineTemp < board.length && board[lineTemp][i] == 'X') {
                            hasVisitedBoard[lineTemp][i] = true;
                            lineTemp++;
                        }
                    }

                    resCount++;
                } else {
                    row++;
                }
            }
        }

        return resCount;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        int count = new BattleshipsinaBoard().countBattleships(board);
        LogUtils.d(TAG, count);
    }
}
