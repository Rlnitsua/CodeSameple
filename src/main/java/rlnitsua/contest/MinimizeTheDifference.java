package rlnitsua.contest;

public class MinimizeTheDifference {
    private int res = 1000_0000;

    public int minimizeTheDifference(int[][] mat, int target) {
        minimizeTheDifference(mat, target, 0, 0);
        return res;
    }

    private void minimizeTheDifference(int[][] mat, int target, int currRow, int currSum) {
        if (currRow == mat.length) {
            res = Math.min(res, Math.abs(currSum - target));
            return;
        }

        for (int j = 0; j < mat[0].length; j++) {
            if (res != 1000_0000 && currSum + mat[currRow][j] > target + res) {
                continue;
            }
            minimizeTheDifference(mat, target, currRow + 1, currSum + mat[currRow][j]);
        }
    }
}
