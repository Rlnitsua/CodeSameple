package lizbyu.array;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeofanArray {
    private static final String TAG = "DegreeofanArray";

    public int findShortestSubArray(int[] nums) {
        List<Integer> keyList = calculateDegreeFromArray(nums);

        int res = Integer.MAX_VALUE;
        for (int key : keyList) {
            int currentLength = calculateLengthFromKey(nums, key);
            res = Math.min(res, currentLength);
        }

        return res;
    }

    private List<Integer> calculateDegreeFromArray(int[] arrs) {
        List<Integer> keyList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arrs) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                keyList.add(key);
            }
        }

        return keyList;
    }

    private int calculateLengthFromKey(int[] nums, int key) {
        int startPosition = 0;
        int stopPosition = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                startPosition = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == key) {
                stopPosition = i;
                break;
            }
        }

        return stopPosition - startPosition + 1;
    }

    public static void main(String[] args) {
        DegreeofanArray demo = new DegreeofanArray();
        int[] nums0 = new int[]{1, 2, 2, 3, 1};
        int[] nums1 = new int[]{1, 2, 2, 3, 1, 4, 2};
        LogUtils.d(TAG, demo.findShortestSubArray(nums0));
        LogUtils.d(TAG, demo.findShortestSubArray(nums1));
    }
}
