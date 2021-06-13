package rlnitsua.contest;

public class IsCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] isCovered = new boolean[right - left + 1];

        for (int i = left; i <= right; i++) {
            for (int[] range : ranges) {
                if (range[0] <= i && range[1] >= i) {
                    isCovered[i - left] = true;
                    break;
                }
            }
        }

        for (boolean covered : isCovered) {
            if (!covered) {
                return false;
            }
        }
        return true;
    }
}
