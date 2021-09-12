package rlnitsua.contest;

import java.util.HashMap;
import java.util.Map;

public class InterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>();
        for (int[] r : rectangles) {
            double key = (double)r[0]/r[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long res = 0;
        for (int num : map.values()) {
            res += ((long)num * (num - 1)) / 2;
        }
        return res;
    }
}
