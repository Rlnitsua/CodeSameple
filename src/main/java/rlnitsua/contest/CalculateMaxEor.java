package rlnitsua.contest;

import java.util.LinkedList;
import java.util.Queue;

public class CalculateMaxEor {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int xorSum = 0;

        for (int num : nums) {
            xorSum ^= num;
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = calculateNegation(xorSum, maximumBit);
            xorSum ^= nums[nums.length - 1 - i];
        }

        return res;
    }

    private int calculateNegation(int num, int maximumBit) {
        Queue<Integer> queue = new LinkedList<>();

        while (num != 0) {
            queue.offer(num % 2 == 0 ? 0 : 1);
            num /= 2;
        }

        int res = 0;
        for (int i = 0; i < maximumBit; i++) {
            if (!queue.isEmpty()) {
                res += (queue.poll() == 0 ? 1 : 0) * Math.pow(2, i);
            } else {
                res += Math.pow(2, i);
            }
        }

        return res;
    }
}
