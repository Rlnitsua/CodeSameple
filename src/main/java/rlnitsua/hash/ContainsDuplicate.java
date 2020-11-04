package rlnitsua.hash;

import rlnitsua.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainsDuplicate {
    private static final String TAG = "ContainsDuplicate";

    public boolean containsDuplicate0(int[] nums) {
        List<Integer> numList = new ArrayList<Integer>();
        for (int num : nums) {
            if (numList.contains(num)) {
                return true;
            } else {
                numList.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < (nums.length - 1); i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 1};
//		int[] nums = {1};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new ContainsDuplicate().containsDuplicate(nums));
    }
}
