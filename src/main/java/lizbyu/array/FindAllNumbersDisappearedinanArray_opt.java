package lizbyu.array;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray_opt {
    private static final String TAG = "FindAllNumbersDisappearedinanArray_opt";

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int var = Math.abs(nums[i]) - 1;
            if (nums[var] > 0) {
                nums[var] = -nums[var];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new FindAllNumbersDisappearedinanArray_opt().findDisappearedNumbers(nums));
    }
}
