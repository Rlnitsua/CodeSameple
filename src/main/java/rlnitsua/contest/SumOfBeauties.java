package rlnitsua.contest;

public class SumOfBeauties {
    public int sumOfBeauties(int[] nums) {
        int[] minArr = calculateMinArr(nums);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i - 1]);
            sum += calculateBeauty(i, nums, minArr, max);
        }
        return sum;
    }

    private int[] calculateMinArr(int[] nums) {
        int[] minArr = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }
        return minArr;
    }

    private int calculateBeauty(int i, int[] nums, int[] minArr, int max) {
        if (nums[i] > max && nums[i] < minArr[i + 1]) {
            return 2;
        } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
            return 1;
        }
        return 0;
    }
}
