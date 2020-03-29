package lizbyu.contest;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerinanArray {
    public int findLucky(int[] arr) {
        int res = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                res = entry.getKey();
            }
        }
        return res;
    }
}
