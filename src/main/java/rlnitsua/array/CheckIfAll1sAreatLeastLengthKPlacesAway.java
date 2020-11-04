package rlnitsua.array;

public class CheckIfAll1sAreatLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }

        boolean isFirstOne = true;
        int lastIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (isFirstOne) {
                    isFirstOne = false;
                } else if (i - lastIndex <= k) {
                    return false;
                }
                lastIndex = i;
            }
        }

        return true;
    }
}
