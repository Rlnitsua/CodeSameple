package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class Minesweeper {
    private static final String TAG = "Minesweeper";

    private int xLength;
    private int yLength;

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        xLength = board[0].length;
        yLength = board.length;

        switch (board[x][y]) {
            case 'M':
                board[x][y] = 'X';
                break;
            case 'E':
                int adjacentMineCount = getAdjacentMine(board, click);
                if (adjacentMineCount != -1) {
                    board[x][y] = String.valueOf(adjacentMineCount).toCharArray()[0];
                } else {
                    showBlankBoard(board, click);
                }
                break;
            default:
                break;
        }
        return board;
    }

    private int getAdjacentMine(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        int count = 0;

        for (int i = (x - 1); i <= (x + 1); i++) {
            for (int j = (y - 1); j <= (y + 1); j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (i >= 0 && i < yLength && j >= 0 && j < xLength) {
                    if (board[i][j] == 'M') {
                        count++;
                    }
                }
            }
        }

        return count == 0 ? -1 : count;
    }

    private boolean[][] hasVisited = new boolean[board.length][board[0].length];

    private void showBlankBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        board[x][y] = 'B';
        LogUtils.d(TAG, "check click : " + click[0] + "," + click[1]);

        for (int i = (x - 1); i <= (x + 1); i++) {
            for (int j = (y - 1); j <= (y + 1); j++) {
                if (i == x && j == y) {
                    continue;
                }

                if (i >= 0 && i < yLength && j >= 0 && j < xLength) {
                    if (hasVisited[i][j]) {
                        continue;
                    }

                    hasVisited[i][j] = true;
                    int adjacentMine = getAdjacentMine(board, new int[]{i, j});
                    if (adjacentMine != -1) {
                        board[i][j] = String.valueOf(adjacentMine).toCharArray()[0];
                    } else {
                        showBlankBoard(board, new int[]{i, j});
                    }
                }
            }
        }
    }

    private static char[][] board = {
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}
    };

    public static void main(String[] args) {
//		LogUtils.d(TAG, new Minesweeper().updateBoard(board, new int[]{3, 0}));
        LogUtils.d(TAG, new Minesweeper().updateBoard(board, new int[]{0, 0}));
    }
}
