package lizbyu.array;

import java.util.HashMap;
import java.util.Map;

public class NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> info1 = getInfo(nums1);
        Map<Long, Integer> info2 = getInfo(nums2);
        int res = 0;

        for (int value : nums1) {
            res += info2.getOrDefault((long)value * value, 0);
        }
        for (int value : nums2) {
            res += info1.getOrDefault((long)value * value, 0);
        }

        return res;
    }

    private Map<Long, Integer> getInfo(int[] nums) {
        Map<Long, Integer> info = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Long res = (long) nums[i] * (long)nums[j];
                if (info.containsKey(res)) {
                    info.put(res, info.get(res) + 1);
                } else {
                    info.put(res, 1);
                }
            }
        }
        return info;
    }
}
