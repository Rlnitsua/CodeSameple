package rlnitsua.math;

import rlnitsua.utils.log.LogUtils;

public class PlusOne {
    private static final String TAG = "PlusOne";

    public int[] plusOne(int[] digits) {
        boolean isOverflow = false;
        for (int i = (digits.length - 1); i >= 0; i--) {
            if (digits[i] == 9) {
                if (i == 0) {
                    isOverflow = true;
                }
                digits[i] = 0;
                continue;
            } else {
                digits[i] += 1;
                break;
            }
        }

        int[] plusOne = null;
        if (isOverflow) {
            plusOne = new int[digits.length + 1];
            plusOne[0] = 1;
            for (int i = 1; i < plusOne.length; i++) {
                plusOne[i] = digits[i - 1];
            }
        } else {
            plusOne = digits;
        }
        return plusOne;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9, 9, 9, 9};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new PlusOne().plusOne(nums));
    }
}
