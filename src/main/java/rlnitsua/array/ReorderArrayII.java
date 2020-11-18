package rlnitsua.array;

// the relative position of odd and even numbers can be changed
public class ReorderArrayII {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
            } else if (nums[right] % 2 == 0) {
                right--;
            } else if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }

        return nums;
    }
}
