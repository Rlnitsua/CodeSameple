package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
    private static final String TAG = "FindAllDuplicatesinanArray";

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] < 0) {
                res.add(Math.abs(num));
            } else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        LogUtils.d(TAG, new FindAllDuplicatesinanArray().findDuplicates(nums));
    }
}
