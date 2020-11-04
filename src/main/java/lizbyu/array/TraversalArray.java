package lizbyu.array;

public class TraversalArray {
    public int[] printMatrix (int[][] matrix) {
        Direction direction = Direction.RIGHT;

        boolean[][] usedMatrix = new boolean[matrix.length][matrix[0].length];
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int row = 0;
        int column = 0;

        while (index < res.length - 1) {
            switch (direction) {
                case RIGHT:
                    if (column != matrix[0].length - 1 && !usedMatrix[row][column + 1]) {
                        res[index] = matrix[row][column];
                        usedMatrix[row][column] = true;
                        index++;
                        column++;
                    } else {
                        direction = Direction.DOWN;
                    }
                    break;
                case DOWN:
                    if (row != matrix.length - 1 && !usedMatrix[row + 1][column]) {
                        res[index] = matrix[row][column];
                        usedMatrix[row][column] = true;
                        index++;
                        row++;
                    } else {
                        direction = Direction.LEFT;
                    }
                    break;
                case LEFT:
                    if (column != 0 && !usedMatrix[row][column - 1]) {
                        res[index] = matrix[row][column];
                        usedMatrix[row][column] = true;
                        index++;
                        column--;
                    } else {
                        direction = Direction.UP;
                    }
                    break;
                case UP:
                    if (row != 0 && !usedMatrix[row - 1][column]) {
                        res[index] = matrix[row][column];
                        usedMatrix[row][column] = true;
                        index++;
                        row--;
                    } else {
                        direction = Direction.RIGHT;
                    }
                    break;
            }
        }

        res[res.length - 1] = matrix[row][column];
        return res;
    }


    private enum Direction {
        RIGHT, DOWN, LEFT, UP
    }
}
