package lizbyu.array;

public class AvailableCapturesforRook {
    private int count = 0;
    private int whiteRookColumn = -1;
    private int whiteRookRow = -1;

    public int numRookCaptures(char[][] board) {
        calculateWhiteRookPosition(board);

        for (int j = whiteRookRow - 1; j >= 0; j--) {
            if (calculateCount(board, whiteRookColumn, j)) break;
        }
        for (int j = whiteRookRow + 1; j < board[0].length; j++) {
            if (calculateCount(board, whiteRookColumn, j)) break;
        }
        for (int i = whiteRookColumn - 1; i >= 0; i--) {
            if (calculateCount(board, i, whiteRookRow)) break;
        }
        for (int i = whiteRookColumn + 1; i < board.length; i++) {
            if (calculateCount(board, i, whiteRookRow)) break;
        }

        return count;
    }

    private void calculateWhiteRookPosition(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    whiteRookColumn = i;
                    whiteRookRow = j;
                    break;
                }
            }
            if (whiteRookColumn != -1) {
                break;
            }
        }
    }

    private boolean calculateCount(char[][] board, int column, int row) {
        char target = board[column][row];
        if (isBlackPawn(target)) {
            count++;
            return true;
        } else return isWhite(target) || isBlackRookOrBishop(target);
    }

    private boolean isWhite(char ch) {
        return ch == 'R' || ch == 'B' || ch == 'P';
    }

    private boolean isBlackRookOrBishop(char ch) {
        return ch == 'r' || ch == 'b';
    }

    private boolean isBlackPawn(char ch) {
        return ch == 'p';
    }
}
