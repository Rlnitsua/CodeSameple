package lizbyu.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        // 1. build map
        Map<Integer, Integer> map = getMap(values, labels);
        // 2. sort array
        sortList(values);
        // 3. add list
        List<Integer> resList = calculateList(values, map, num_wanted, use_limit);
        // 4. calculate res
        return calculateSum(resList);
    }

    private Map<Integer, Integer> getMap(int[] values, int[] labels) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            if (!map.containsKey(values[i])) {
                map.put(values[i], labels[i]);
            }
        }
        return map;
    }

    private void sortList(int[] values) {
        for (int j = 0; j < values.length - 1; j++) {
            for (int i = 0; i < values.length - 1 - j; i++) {
                if (values[i] < values[i + 1]) {
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                }
            }
        }
    }

    private List<Integer> calculateList(int[] values, Map<Integer, Integer> map, int num_wanted,
                                        int use_limit) {
        Map<Integer, Integer> laberCounter = new HashMap<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (numList.size() == num_wanted) {
                return numList;
            }
            int laber = map.get(values[i]);
            if (!laberCounter.containsKey(laber) || laberCounter.get(laber) < use_limit) {
                numList.add(values[i]);
                if (!laberCounter.containsKey(laber)) {
                    laberCounter.put(laber, 1);
                } else {
                    laberCounter.put(laber, laberCounter.get(laber) + 1);
                }
            }
        }
        return numList;
    }

    private int calculateSum(List<Integer> resList) {
        int res = 0;
        for (Integer num : resList) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        LargestValuesFromLabels l = new LargestValuesFromLabels();
        int[] values = new int[]{5, 4, 3, 2, 1};
        int[] labels = new int[]{1, 3, 3, 3, 2};
        int largestValsFromLabels = l.largestValsFromLabels(values, labels, 3, 2);
        System.out.println(largestValsFromLabels);
    }
}
