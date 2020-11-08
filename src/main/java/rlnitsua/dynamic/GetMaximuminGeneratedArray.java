package rlnitsua.dynamic;

public class GetMaximuminGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] arr = new int[n + 1];
        int max = 0;
        arr[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (i * 2 < arr.length) {
                arr[i * 2] = arr[i];
                max = Math.max(max, arr[i * 2]);
            }
            if (i * 2 - 1 < arr.length) {
                arr[i * 2 - 1] = arr[i] + arr[i - 1];
                max = Math.max(max, arr[i * 2 - 1]);
            }
        }

        return max;
    }
}
