package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

import java.util.Arrays;

public class RotateArray {
    private static final String TAG = "RotateArray";

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        int[] temp = Arrays.copyOf(nums, nums.length);

        System.arraycopy(temp, temp.length - k, nums, 0, k);
        System.arraycopy(temp, 0, nums, k, nums.length - k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//		int[] nums = {1};
        new RotateArray().rotate(nums, 3);
        LogUtils.d(TAG, nums);
    }
}
