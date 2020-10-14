package lizbyu.math;

import lizbyu.utils.log.LogUtils;

import java.util.Arrays;

public class Heaters {
    private static final String TAG = "Heaters";

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = Integer.MIN_VALUE;
        int i = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
//		int[] hourse = {1, 2, 3};
//		int[] heaters = {1};
//		int[] hourse = {1, 2, 3};
//		int[] heaters = {2};
        int[] hourse = {1, 2, 3, 4};
        int[] heaters = {1, 4};
//		int[] hourse = {1,2,3,4,5};
//		int[] heaters = {1,2,3,4};
//		int[] hourse = {1};
//		int[] heaters = {1,2,3,4};
//		int[] hourse = {1,2,3,5,15};
//		int[] heaters = {2,30};
        LogUtils.d(TAG, new Heaters().findRadius(hourse, heaters));
    }
}
