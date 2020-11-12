package rlnitsua.array;

public class MaxSumOfSubArray {
    public int maxsumofSubarray (int[] arr) {
        int sum = 0;
        int max = 0;

        for (int num : arr) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
