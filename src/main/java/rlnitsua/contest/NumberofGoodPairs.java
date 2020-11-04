package rlnitsua.contest;

import java.util.HashMap;
import java.util.Map;

public class NumberofGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int res = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                continue;
            }

            int val;
            if (numMap.containsKey(entry.getKey())) {
                val = numMap.get(entry.getKey());
            } else {
                val = calculateVal(entry.getValue());
                numMap.put(entry.getKey(), val);
            }
            res += val;
        }

        return res;
    }

    private int calculateVal(int key) {
        return (key * (key - 1)) / 2;
    }
}
