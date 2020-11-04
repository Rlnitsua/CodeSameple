package rlnitsua.easy;

public class ThirdMax {
    public int thirdMax(int[] nums) {

        boolean existConvert = true;

        for (int j = 0; j < 3; j++) {
            if (existConvert) {
                existConvert = false;
                for (int i = 0; i < (nums.length - 1 - j); i++) {
                    if (nums[i] > nums[i + 1]) {
                        existConvert = true;
                        swap(nums, i, i + 1);
                    }
                }
            }
        }

        if (nums.length >= 3) {
            return nums[nums.length - 3];
        } else {
            return nums[nums.length - 1];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//		int[] a = {5, 2, 3, 1, 4};
        int[] b = {2, 2, 3, 1};
        System.out.println("Third max : " + new ThirdMax().thirdMax(b));
    }
}
