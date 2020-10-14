package lizbyu.hash;

import lizbyu.utils.log.LogUtils;

import java.util.*;
import java.util.Map.Entry;

public class SortCharactersByFrequency {
    private static final String TAG = "SortCharactersByFrequency";

    public String frequencySort(String s) {
        if (s == null || s.equals("")) {
            return s;
        }

        Map<Character, Integer> chMap = initTreeMap(s.toCharArray());
        List<Entry<Character, Integer>> sortedEntryList = sortTreeMap(chMap);
        return getRes(sortedEntryList);
    }

    private Map<Character, Integer> initTreeMap(char[] chArr) {
        Map<Character, Integer> chMap = new TreeMap<>();
        for (char ch : chArr) {
            if (chMap.containsKey(ch)) {
                chMap.put(ch, chMap.get(ch) + 1);
            } else {
                chMap.put(ch, 1);
            }
        }
        return chMap;
    }

    private List<Entry<Character, Integer>> sortTreeMap(Map<Character, Integer> chMap) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(chMap.entrySet());
        Collections.sort(list, new MyComparator());
        return list;
    }

    private class MyComparator
            implements Comparator<Map.Entry<Character, Integer>> {
        @Override
        public int compare(Entry<Character, Integer> o1,
                           Entry<Character, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    }

    private String getRes(List<Entry<Character, Integer>> sortedEntryList) {
        StringBuffer sb = new StringBuffer();
        for (Entry<Character, Integer> entry : sortedEntryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        LogUtils.d(TAG, sortCharactersByFrequency.frequencySort("abb"));
        LogUtils.d(TAG, sortCharactersByFrequency.frequencySort("Aabb"));
    }
}
