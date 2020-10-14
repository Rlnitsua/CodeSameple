package lizbyu.design;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DesignTicTacToe {
    private static final String TAG = "DesignTicTacToe";

    private int size = 0;
    private List<double[]> player1Points;
    private Set<Integer> player1Rows;
    private Set<Integer> player1Cols;
    private Set<Double> player1Disc;
    private List<double[]> player2Points;
    private Set<Double> player2Disc;
    private Set<Integer> player2Rows;
    private Set<Integer> player2Cols;

    public DesignTicTacToe(int n) {
        size = n;

        player1Points = new ArrayList<>();
        player1Disc = new HashSet<>();
        player1Rows = new HashSet<>();
        player1Cols = new HashSet<>();

        player2Points = new ArrayList<>();
        player2Disc = new HashSet<>();
        player2Rows = new HashSet<>();
        player2Cols = new HashSet<>();
    }

    public int move(int row, int col, int player) {
        int playerIndex = isExist(row, col, player);
        if (playerIndex != -1) {
            return playerIndex;
        } else {
            addPointer(row, col, player);
            return 0;
        }
    }


    private int isExist(int row, int col, int playerIndex) {
        if (existRow(row, playerIndex)) {
            return playerIndex;
        } else if (existCol(col, playerIndex)) {
            return playerIndex;
        } else if (existDiagonal(row, col, playerIndex)) {
            return playerIndex;
        } else {
            return -1;
        }
    }

    private boolean existRow(int row, int playerIndex) {
        if (playerIndex == 1) {
            return findRow(row, player1Rows);
        } else {
            return findRow(row, player2Rows);
        }
    }

    private boolean findRow(int row, Set<Integer> playerRows) {
        if ((playerRows.size() == size - 1) && (playerRows.contains(row))) {
            return true;
        }
        return false;
    }

    private boolean existCol(int col, int playerIndex) {
        if (playerIndex == 1) {
            return findCol(col, player1Cols);
        } else {
            return findCol(col, player2Cols);
        }
    }

    private boolean findCol(int col, Set<Integer> playerCols) {
        if ((playerCols.size() == size - 1) && (playerCols.contains(col))) {
            return true;
        }
        return false;
    }

    private boolean existDiagonal(int row, int col, int playerIndex) {
        if (playerIndex == 1) {
            return findDiagonal(row, col, player1Points, player1Disc);
        } else {
            return findDiagonal(row, col, player2Points, player2Disc);
        }
    }

    private boolean findDiagonal(int row, int col,
                                 List<double[]> playerPoints, Set<Double> playerDisc) {
        if ((playerDisc.size() == size - 1) && (playerDisc.contains(Double.valueOf(0)))) {
        }
        for (double[] playerP : playerPoints) {
            if (row != playerP[0]) {
                double disc = (col - playerP[1]) / (row - playerP[0]);
                if (playerDisc.contains(disc)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void addPointer(int row, int col, int playerIndex) {
        if (playerIndex == 1) {
            addPointerForPlayer(row, col, player1Points, player1Disc);
            addPointerCowCol(row, col, player1Rows, player1Cols);
        } else {
            addPointerForPlayer(row, col, player2Points, player2Disc);
            addPointerCowCol(row, col, player2Rows, player2Cols);
        }
    }

    private void addPointerForPlayer(int row, int col,
                                     List<double[]> playerPoints, Set<Double> playerDisc) {
        for (double[] point : playerPoints) {
            if (row != point[0]) {
                playerDisc.add((col - point[1]) / (row - point[0]));
            }
        }
        playerPoints.add(new double[]{row, col});
    }

    private void addPointerCowCol(int row, int col, Set<Integer> playerRows,
                                  Set<Integer> playerCols) {
        playerRows.add(row);
        // error invoke in jdk 1.8
//		Collections.sort(playerRows);
        playerCols.add(col);
//		Collections.sort(playerCols);
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        DesignTicTacToe toe = new DesignTicTacToe(3);
        LogUtils.d(TAG, toe.move(0, 0, 1));
        LogUtils.d(TAG, toe.move(0, 2, 2));
        LogUtils.d(TAG, toe.move(2, 2, 1));
        LogUtils.d(TAG, toe.move(1, 1, 2));
        LogUtils.d(TAG, toe.move(2, 0, 1));
        LogUtils.d(TAG, toe.move(1, 0, 2));
        LogUtils.d(TAG, toe.move(2, 1, 1));
    }
}
