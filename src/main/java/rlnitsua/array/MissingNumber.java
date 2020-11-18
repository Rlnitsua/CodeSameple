package rlnitsua.array;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int l = -1;
        int r = nums.length;

        while (l + 1 != r) {
            int mid = (l + r) / 2;
            if (nums[mid] == mid) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r == nums.length ? r : nums[r] - 1;
    }
}
