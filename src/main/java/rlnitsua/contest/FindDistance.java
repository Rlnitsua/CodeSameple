package rlnitsua.contest;

public class FindDistance {
    public int getMinDistance(int[] nums, int target, int start) {
        int index = start;
        int distance = 0;
        boolean isPre = false;

        while (nums[index] != target) {
            if (!isPre) {
                isPre = true;
                distance++;
                if (start - distance >= 0 && start - distance < nums.length) {
                    index = start - distance;
                }
            } else {
                isPre = false;
                if (start + distance >= 0 && start + distance < nums.length) {
                    index = start + distance;
                }
            }
        }

        return distance;
    }
}
