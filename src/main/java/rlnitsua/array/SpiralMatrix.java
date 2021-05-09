package rlnitsua.array;

public class SpiralMatrix {
    int curr = 1;
    int res = 0;

    public int orchestraLayout(int num, int xPos, int yPos) {
        int startRow = 0;
        int endRow = num - 1;
        int startColumn = 0;
        int endColumn = num - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            traversePath(startRow++, endRow--, startColumn++, endColumn--, calculateCount(num, xPos, yPos));
        }

        return res;
    }

    private int calculateCount(int num, int xPos, int yPos) {
        if (num % 2 == 0) {
            int pathIndex = 0;
            if (xPos <= num / 2) {
                pathIndex = xPos + 1;
                int count = 0;
                for (int i = 1; i < pathIndex; i++) {
                    count += (num - (i - 1) * 2) * 2 + ((num - (i - 1) * 2) - 2) * 2;
                }
                if (yPos == 0) {
                    count += xPos + 1;
                } else if (yPos == num - 1) {
//                    count += ..
                } else {

                }
            } else {
                pathIndex = num - xPos;
            }
        } else {

        }
        return 0;
    }

    private void traversePath(int startRow, int endRow, int startColumn, int endColumn, int count) {
        if (startRow == endRow) {
            res = getNum();
        } else {
            int currRow = startRow;
            int currColumn = startColumn;

            while (currColumn < endColumn) {
                res = getNum();
                currColumn++;
                if (--count == 0) {
                    return;
                }
            }
            while (currRow < endRow) {
                res = getNum();
                currRow++;
                if (--count == 0) {
                    return;
                }
            }
            while (currColumn > startColumn) {
                res = getNum();
                currColumn--;
                if (--count == 0) {
                    return;
                }
            }
            while (currRow > startRow) {
                res = getNum();
                currRow--;
                if (--count == 0) {
                    return;
                }
            }
        }
    }


    private int getNum() {
        if (curr == 10) {
            curr = 1;
        }
        return curr++;
    }
}
