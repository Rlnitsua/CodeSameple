package rlnitsua.array;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfEatenApples {
    private int res = 0;

    public int eatenApples(int[] apples, int[] days) {
        Map<Integer, int[]> info = calculateInfo(apples, days);
        int day = 1;

        while (hasApple(info, day) || day <= apples.length) {
            eatApple(info, day);
            day++;
        }

        return res;
    }

    private Map<Integer, int[]> calculateInfo(int[] apples, int[] days) {
        Map<Integer, int[]> res = new HashMap<>();
        for (int i = 0; i < apples.length; i++) {
            res.put(i + 1, new int[]{apples[i], days[i]});
        }
        return res;
    }

    private boolean hasApple(Map<Integer, int[]> info, int day) {
        for (Map.Entry<Integer, int[]> entry : info.entrySet()) {
            if (entry.getKey() <= day
                    && entry.getValue()[1] > 0
                    && entry.getValue()[0] > 0) {
                return true;
            }
        }
        return false;
    }

    private void eatApple(Map<Integer, int[]> info, int day) {
        int targetDay = -1;
        int recentDuration = Integer.MAX_VALUE;

        for (Map.Entry<Integer, int[]> entry : info.entrySet()) {
            if (entry.getKey() <= day
                    && entry.getValue()[0] > 0
                    && entry.getValue()[1] > 0) {
                if (entry.getValue()[1] < recentDuration) {
                    recentDuration = entry.getValue()[1];
                    targetDay = entry.getKey();
                }
            }
        }

        if (targetDay == -1) {
            return;
        }

        // eat
        int[] targetIntArr = new int[]{info.get(targetDay)[0] - 1,
                info.get(targetDay)[1]};
        info.put(targetDay, targetIntArr);
        res++;

        // updateDate
        for (int nextDay : info.keySet()) {
            if (nextDay <= day) {
                info.put(nextDay, new int[]{info.get(nextDay)[0],
                        info.get(nextDay)[1] - 1});
            }
        }
    }
}
