package rlnitsua.contest;

import java.util.Map;
import java.util.TreeMap;

public class ReductionOperations {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int last = 0;
        int index = map.size();

        for (int numCount : map.values()) {
            if (index == 1) {
                return count;
            }
            last += numCount;
            count += last;
            index--;
        }

        return count;
    }
}
