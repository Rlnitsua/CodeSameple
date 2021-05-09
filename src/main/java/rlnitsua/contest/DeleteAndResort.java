package rlnitsua.contest;

import java.util.Map;
import java.util.TreeMap;

public class DeleteAndResort {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = calculate(res, entry.getKey(), entry.getValue());
        }

        return res;
    }

    private int calculate(int start, int num, int count) {
        if (count >= (num - start)) {
            return num;
        } else {
            return start + count;
        }
    }
}
