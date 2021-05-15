package rlnitsua.contest;

import java.util.Arrays;

public class RotateTheBox {
    private static final char STONE = '#';
    private static final char OBSTACLE = '*';
    private static final char SPACE = '.';

    public char[][] rotateTheBox(char[][] box) {
        int originRow = box.length;
        int originColumn = box[0].length;
        char[][] res = new char[originColumn][originRow];

        for (int i = 0; i < originRow; i++) {
            char[] targetColumn = calculateTarget(box[i]);
            copyRes(res, targetColumn, i);
        }
        return res;
    }

    private char[] calculateTarget(char[] oneBox) {
        char[] targetBox = new char[oneBox.length];
        Arrays.fill(targetBox, '.');
        int originIndex = oneBox.length - 1;
        int targetIndex = targetBox.length - 1;

        while (originIndex >= 0) {
            if (oneBox[originIndex] == SPACE) {
                originIndex--;
            } else if (oneBox[originIndex] == OBSTACLE) {
                targetIndex = originIndex;
                targetBox[targetIndex] = OBSTACLE;
                originIndex--;
                targetIndex--;
            } else {
                targetBox[targetIndex] = STONE;
                originIndex--;
                targetIndex--;
            }
        }

        return targetBox;
    }

    private void copyRes(char[][] res, char[] targetColumn, int column) {
        for (int i = 0; i < targetColumn.length; i++) {
            res[i][res[0].length - 1 - column] = targetColumn[i];
        }
    }
}
