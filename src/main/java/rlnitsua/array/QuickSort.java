package rlnitsua.array;

public class QuickSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int leftIndex = left;
        int rightIndex = right;
        int pivot = nums[leftIndex];

        while (leftIndex < rightIndex) {
            while (rightIndex > leftIndex && nums[rightIndex] >= pivot) {
                rightIndex--;
            }
            nums[leftIndex] = nums[rightIndex];

            while (leftIndex < rightIndex && nums[leftIndex] <= pivot) {
                leftIndex++;
            }
            nums[rightIndex] = nums[leftIndex];
        }
        nums[leftIndex] = pivot;
        sort(nums, left, leftIndex - 1);
        sort(nums, rightIndex + 1, right);
    }
}
