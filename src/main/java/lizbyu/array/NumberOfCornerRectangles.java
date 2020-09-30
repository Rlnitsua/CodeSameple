package lizbyu.array;

public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int moreJ = j + 1; moreJ < grid[0].length; moreJ++) {
                        if (grid[i][moreJ] == 1) {
                            for (int moreI = i + 1; moreI < grid.length; moreI++) {
                                if (grid[moreI][j] == 1 && grid[moreI][moreJ] == 1) {
                                    res++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}
