package rlnitsua.contest;

import java.util.*;

public class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                list.add(num);
            }
        }
        Collections.sort(list);

        int maxFre = 0;

        for (int key : map.keySet()) {
            int curr = map.get(key) + calculate(map, list, key, k, 1, 0);
            maxFre = Math.max(maxFre, curr);
        }

        return maxFre;
    }

    private int calculate(Map<Integer, Integer> map, List<Integer> list, int key, int k, int start, int sum) {
        if (k == 0) {
            return sum;
        }
        int index = list.indexOf(key);
        if (index == 0) {
            return sum;
        }

        int targetIndex = index - start;
        if (targetIndex < 0) {
            return sum;
        }

        int targetVal = list.get(targetIndex);
        int targetCount = map.get(targetVal);
        if (k <= (key - targetVal) * targetCount) {
            sum += (k / (key - targetVal));
            return sum;
        } else {
            sum += targetCount;
            k -= (key - targetVal) * targetCount;
            return calculate(map, list, key, k, start + 1, sum);
        }
    }
}
