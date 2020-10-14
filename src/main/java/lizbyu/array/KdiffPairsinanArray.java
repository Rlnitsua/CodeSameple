package lizbyu.array;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KdiffPairsinanArray {
    private static final String TAG = "KdiffPairsinanArray";

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        List<Integer> resList = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (resList.contains(nums[i])) {
                continue;
            }

            int res = find(nums, i + 1, nums[i] + k);
            if (res >= 0) {
                resList.add(nums[i]);
            }
        }

        return resList.size();
    }

    private int find(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        LogUtils.d(TAG, new KdiffPairsinanArray().findPairs(nums, 2));
        int[] nums1 = {1, 2, 3, 4, 5};
        LogUtils.d(TAG, new KdiffPairsinanArray().findPairs(nums1, 1));
        int[] nums2 = {1, 3, 1, 5, 4};
        LogUtils.d(TAG, new KdiffPairsinanArray().findPairs(nums2, 0));
    }
}
