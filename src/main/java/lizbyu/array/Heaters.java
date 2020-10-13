package lizbyu.array;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxLen = Integer.MIN_VALUE;
        int lastLeftHeater = 0;
        int houseIndex = 0;

        while (houseIndex < houses.length && houses[houseIndex] <= heaters[lastLeftHeater]) {
            maxLen = Math.max(maxLen, heaters[lastLeftHeater] - houses[houseIndex]);
            houseIndex++;
        }

        for (int i = houseIndex; i < houses.length; i++) {
            while (lastLeftHeater < heaters.length) {
                if (heaters[lastLeftHeater] < houses[i]) {
                    lastLeftHeater++;
                } else if (houses[i] < heaters[lastLeftHeater]) {
                    lastLeftHeater--;
                    int tempLen = Math.min(heaters[lastLeftHeater + 1] - houses[i],
                            houses[i] - heaters[lastLeftHeater]);
                    maxLen = Math.max(maxLen, tempLen);
                    break;
                } else {
                    break;
                }
            }
            if (lastLeftHeater == heaters.length) {
                maxLen = Math.max(maxLen, Math.abs(houses[i] - heaters[heaters.length - 1]));
            }
        }

        return maxLen;
    }
}
