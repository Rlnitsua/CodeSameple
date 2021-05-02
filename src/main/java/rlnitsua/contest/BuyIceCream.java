package rlnitsua.contest;

import java.util.Map;
import java.util.TreeMap;

public class BuyIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int cost : costs) {
            map.put(cost, map.getOrDefault(cost, 0) + 1);
        }

        int res = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (coins <= 0) {
                break;
            }

            int cost = entry.getKey();
            int count = entry.getValue();
            if (coins >= (cost * count)) {
                res += count;
                coins -= (cost * count);
            } else {
                int available = coins / cost;
                res += available;
                return res;
            }
        }

        return res;
    }
}
