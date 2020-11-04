package rlnitsua.hash;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> res = new ArrayList<>();
        for (Entry<Integer, Integer> resEntry : entryList) {
            if (res.size() == k) {
                break;
            }
            res.add(resEntry.getKey());
        }

        return res;
    }
}
