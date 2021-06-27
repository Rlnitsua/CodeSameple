package rlnitsua.contest;


import java.util.Arrays;

public class CanBeIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        int badIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                badIndex = i - 1;
                break;
            }
        }

        return canBeIncreasing(nums, badIndex) || canBeIncreasing(nums, badIndex + 1);
    }

    private boolean canBeIncreasing(int[] nums, int badIndex) {
        for (int i = 1; i < nums.length; i++) {
            if (i == badIndex + 1) {
                if (i - 2 >= 0 && nums[i - 2] >= nums[i]) {
                    return false;
                }
            } else if (i != badIndex && nums[i - 1] >= nums[i]) {
                return false;
            }
        }
        return true;
    }

}
