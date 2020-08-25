package lizbyu.divide.and.conquer;

public class MinimumNumbersofFunctionCallstoMakeTargetArray {
    public int minOperations(int[] nums) {
        if (isAllZero(nums)) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                nums[i]--;
                res++;
            }
        }

        if (isAllZero(nums)) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 2;
        }
        res++;
        return res + minOperations(nums);
    }

    private boolean isAllZero(int[] nums) {
        boolean isAllZero = true;
        for (int num : nums) {
            if (num != 0) {
                isAllZero = false;
                break;
            }
        }
        return isAllZero;
    }
}
