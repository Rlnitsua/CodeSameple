package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    private static final String TAG = "FindAllNumbersDisappearedinanArray";

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> numList = new ArrayList<Integer>();

        for (int num : nums) {
            numList.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numList.contains(i)) {
                numList.add(i);
            }
        }

        for (int i = nums.length; i < numList.size(); i++) {
            nums[i - nums.length] = numList.get(i);
        }

        int dx = numList.size() - nums.length;
        numList.clear();
        for (int i = 0; i < dx; i++) {
            numList.add(nums[i]);
        }

        return numList;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new FindAllNumbersDisappearedinanArray().findDisappearedNumbers(nums));
    }
}
