package rlnitsua.recursive;

public class MinimumOperationstoReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        return minOperations(nums, x, 0, nums.length - 1, 0);
    }

    private int minOperations(int[] nums, int x, int begin, int end, int count) {
        if (x == 0) {
            return count;
        }

        if (begin > end) {
            return -1;
        }

        if (nums[begin] > x && nums[end] > x) {
            return -1;
        } else if (nums[begin] > x) {
            return minOperations(nums, x - nums[end], begin, end - 1, count + 1);
        } else if (nums[end] > x) {
            return minOperations(nums, x - nums[begin], begin + 1, end, count + 1);
        } else {
            int right = minOperations(nums, x - nums[end], begin, end - 1, count + 1);
            int left = minOperations(nums, x - nums[begin], begin + 1, end, count + 1);
            if (right == -1 && left == -1) {
                return -1;
            } else if (right == -1) {
                return left;
            } else if (left == -1) {
                return right;
            } else {
                return Math.min(right, left);
            }
        }
    }
}
