package lizbyu.array;

import lizbyu.utils.log.LogUtils;

public class MaxAreaofIsland {
    private static final String TAG = "MaxAreaofIsland";

    public int maxAreaOfIsland(int[][] grid) {
        boolean visitGrid[][] = new boolean[grid.length][grid[0].length];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (visitGrid[i][j]) {
                    continue;
                }

                if (grid[i][j] == 0) {
                    visitGrid[i][j] = true;
                } else {
                    res = Math.max(res, getAreaByGrid(i, j, grid, visitGrid));
                }
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }

    private int getAreaByGrid(int i, int j, int[][] grid, boolean[][] visitGrid) {
        if (visitGrid[i][j]) {
            return 0;
        }
        visitGrid[i][j] = true;

        if (grid[i][j] == 0) {
            return 0;
        }

        if (j == 0 && i == 0) {
            if ((i == grid.length - 1) && (j == grid[0].length - 1)) {
                return 1;
            } else if (i == grid.length - 1) {
                return 1 + getAreaByGrid(i, j + 1, grid, visitGrid);
            } else if (j == grid[0].length - 1) {
                return 1 + getAreaByGrid(i + 1, j, grid, visitGrid);
            } else {
                return 1 + getAreaByGrid(i + 1, j, grid, visitGrid) + getAreaByGrid(i, j + 1, grid, visitGrid);
            }
        } else if (j == 0 && (i == grid.length - 1)) {
            if ((j == grid[0].length - 1) && i == 0) {
                return 1;
            } else if (j == grid[0].length - 1) {
                return 1 + getAreaByGrid(i - 1, j, grid, visitGrid);
            } else if (i == 0) {
                return 1 + getAreaByGrid(i, j + 1, grid, visitGrid);
            } else {
                return 1 + getAreaByGrid(i - 1, j, grid, visitGrid) + getAreaByGrid(i, j + 1, grid, visitGrid);
            }
        } else if ((j == grid[0].length - 1) && i == 0) {
            if ((j == 0) && (i == grid.length - 1)) {
                return 1;
            } else if (j == 0) {
                return 1 + getAreaByGrid(i + 1, j, grid, visitGrid);
            } else if (i == grid.length - 1) {
                return 1 + getAreaByGrid(i, j - 1, grid, visitGrid);
            } else {
                return 1 + getAreaByGrid(i + 1, j, grid, visitGrid) + getAreaByGrid(i, j - 1, grid, visitGrid);
            }
        } else if ((j == grid[0].length - 1) && (i == grid.length - 1)) {
            if ((j == 0) && (i == 0)) {
                return 1;
            } else if (j == 0) {
                return 1 + getAreaByGrid(i - 1, j, grid, visitGrid);
            } else if (i == 0) {
                return 1 + getAreaByGrid(i, j - 1, grid, visitGrid);
            } else {
                return 1 + getAreaByGrid(i - 1, j, grid, visitGrid) + getAreaByGrid(i, j - 1, grid, visitGrid);
            }
        }

        // up
        if (i == 0) {
            if (i == grid.length - 1) {
                return 1 + getAreaByGrid(i, j - 1, grid, visitGrid) + getAreaByGrid(i, j + 1, grid, visitGrid);
            } else {
                return 1 + getAreaByGrid(i + 1, j, grid, visitGrid) + getAreaByGrid(i, j - 1, grid, visitGrid) + getAreaByGrid(i, j + 1, grid, visitGrid);
            }
        }

        // down
        else if (i == grid.length - 1) {
            return 1 + getAreaByGrid(i - 1, j, grid, visitGrid) + getAreaByGrid(i, j + 1, grid, visitGrid) + getAreaByGrid(i, j - 1, grid, visitGrid);
        }

        // left
        else if (j == 0) {
            if (j == grid[0].length - 1) {
                return 1 + getAreaByGrid(i - 1, j, grid, visitGrid) + getAreaByGrid(i + 1, j, grid, visitGrid);
            } else {
                return 1 + getAreaByGrid(i, j + 1, grid, visitGrid) + getAreaByGrid(i - 1, j, grid, visitGrid) + getAreaByGrid(i + 1, j, grid, visitGrid);
            }
        }

        // right
        else if (j == grid[0].length - 1) {
            return 1 + getAreaByGrid(i - 1, j, grid, visitGrid) + getAreaByGrid(i, j - 1, grid, visitGrid) + getAreaByGrid(i + 1, j, grid, visitGrid);
        } else {
            return 1 + getAreaByGrid(i - 1, j, grid, visitGrid) + getAreaByGrid(i + 1, j, grid, visitGrid)
                    + getAreaByGrid(i, j + 1, grid, visitGrid) + getAreaByGrid(i, j - 1, grid, visitGrid);
        }
    }

    public static void main(String[] args) {
        MaxAreaofIsland maxAr = new MaxAreaofIsland();
        int[][] grid = getGrid();
//		int[][] grid = new int[][] {{1}};
//		int[][] grid = new int[][] {{0, 1, 0}};
//		int[][] grid = new int[][] {{0}, {1}, {0}};
        LogUtils.d(TAG, maxAr.maxAreaOfIsland(grid));
    }

    private static int[][] getGrid() {
        int[][] s = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        return s;
    }
}
