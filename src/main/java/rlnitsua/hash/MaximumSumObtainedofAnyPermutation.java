package rlnitsua.hash;

import java.util.Arrays;

public class MaximumSumObtainedofAnyPermutation {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] times = new int[nums.length];
        for (int[] request : requests) {
            for (int i = request[0]; i <= request[1]; i++) {
                times[i]++;
            }
        }
        Arrays.sort(times);
        Arrays.sort(nums);

        double sum = 0;
        for (int i = times.length - 1; i >= 0; i--) {
            if (times[i] == 0) {
                break;
            }
            sum += (nums[i] * times[i]) % (Math.pow(10, 9) + 7);
        }

        return (int) (sum % (Math.pow(10, 9) + 7));
    }
}
