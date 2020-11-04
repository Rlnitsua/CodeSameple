package rlnitsua.easy;

import rlnitsua.utils.log.LogUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    private static final String TAG = "RelativeRanks";

    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] numsTemp = Arrays.copyOf(nums, nums.length);
        Map<Integer, String> map = getMap(numsTemp);

        String[] res = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    private Map<Integer, String> getMap(int[] nums) {
        Map<Integer, String> intgerMap = new HashMap<Integer, String>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < (nums.length - 1 - i); j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i <= 2) {
                if (i == 0) {
                    intgerMap.put(nums[i], "Gold Medal");
                } else if (i == 1) {
                    intgerMap.put(nums[i], "Silver Medal");
                } else if (i == 2) {
                    intgerMap.put(nums[i], "Bronze Medal");
                }
            } else {
                intgerMap.put(nums[i], i + 1 + "");
            }
        }

        return intgerMap;
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        LogUtils.d(TAG, new RelativeRanks().findRelativeRanks(nums));

        int[] nums1 = {10, 3, 8, 9, 4};
        LogUtils.d(TAG, new RelativeRanks().findRelativeRanks(nums1));
    }
}
