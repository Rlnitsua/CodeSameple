package rlnitsua.array;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
