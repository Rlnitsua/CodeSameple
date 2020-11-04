package rlnitsua.array;

public class CountNegativeNumbersinaSortedMatrix {
    public int countNegatives(int[][] grid) {
        int countNonNegative = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] >= 0) {
                    countNonNegative++;
                } else {
                    if (j == 0) {
                        return grid.length * grid[0].length - countNonNegative;
                    } else {
                        break;
                    }
                }
            }
        }
        return grid.length * grid[0].length - countNonNegative;
    }
}
