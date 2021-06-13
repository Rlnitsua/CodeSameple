package rlnitsua.contest;

public class FindRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        if (!checkOne(mat, target)) {
            return false;
        }

        return check0(mat, target) || check90(mat, target)
                || check180(mat, target) || check270(mat, target);
    }

    private boolean checkOne(int[][] mat, int[][] target) {
        return oneNumber(mat) == oneNumber(target);
    }

    private int oneNumber(int[][] matrix) {
        int count = 0;
        for (int[] arr : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (arr[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check0(int[][] mat, int[][] target) {
        int index = 0;
        int row = mat.length;
        int column = mat[0].length;
        int originRow = 0;
        int originColumn = 0;
        int targetRow = 0;
        int targetColumn = 0;
        while (index < row * column) {
            if (mat[originRow][originColumn] != target[targetRow][targetColumn]) {
                return false;
            }
            index++;
            if (originColumn < column - 1) {
                originColumn++;
            } else {
                originColumn = 0;
                originRow++;
            }
            if (targetColumn < column - 1) {
                targetColumn++;
            } else {
                targetColumn = 0;
                targetRow++;
            }
        }
        return true;
    }

    private boolean check90(int[][] mat, int[][] target) {
        int index = 0;
        int row = mat.length;
        int column = mat[0].length;
        int originRow = 0;
        int originColumn = 0;
        int targetRow = row - 1;
        int targetColumn = 0;
        while (index < row * column) {
            if (mat[originRow][originColumn] != target[targetRow][targetColumn]) {
                return false;
            }
            index++;
            if (originColumn < column - 1) {
                originColumn++;
            } else {
                originColumn = 0;
                originRow++;
            }
            if (targetRow > 0) {
                targetRow--;
            } else {
                targetRow = row - 1;
                targetColumn++;
            }
        }
        return true;
    }

    private boolean check180(int[][] mat, int[][] target) {
        int index = 0;
        int row = mat.length;
        int column = mat[0].length;
        int originRow = 0;
        int originColumn = 0;
        int targetRow = row - 1;
        int targetColumn = column - 1;
        while (index < row * column) {
            if (mat[originRow][originColumn] != target[targetRow][targetColumn]) {
                return false;
            }
            index++;
            if (originColumn < column - 1) {
                originColumn++;
            } else {
                originColumn = 0;
                originRow++;
            }
            if (targetColumn > 0) {
                targetColumn--;
            } else {
                targetColumn = column - 1;
                targetRow--;
            }
        }
        return true;
    }

    private boolean check270(int[][] mat, int[][] target) {
        int index = 0;
        int row = mat.length;
        int column = mat[0].length;
        int originRow = 0;
        int originColumn = 0;
        int targetRow = 0;
        int targetColumn = column - 1;
        while (index < row * column) {
            if (mat[originRow][originColumn] != target[targetRow][targetColumn]) {
                return false;
            }
            index++;
            if (originColumn < column - 1) {
                originColumn++;
            } else {
                originColumn = 0;
                originRow++;
            }
            if (targetRow < row - 1) {
                targetRow++;
            } else {
                targetRow = 0;
                targetColumn--;
            }
        }
        return true;
    }
}
