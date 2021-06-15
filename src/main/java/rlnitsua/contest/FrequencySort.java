package rlnitsua.contest;

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Integer, List<Character>> info = new TreeMap<>((o1, o2) -> o2 - o1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (info.containsKey(entry.getValue())) {
                info.get(entry.getValue()).add(entry.getKey());
            } else {
                List<Character> list = new ArrayList<>();
                list.add(entry.getKey());
                info.put(entry.getValue(), list);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int count : info.keySet()) {
            for (char ch : info.get(count)) {
                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
