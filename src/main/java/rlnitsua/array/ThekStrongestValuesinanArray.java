package rlnitsua.array;

import java.util.Arrays;

public class ThekStrongestValuesinanArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) / 2];

        int[] res = new int[k];
        int index = 0;
        int hi = arr.length - 1;
        int lo = 0;

        while (k > 0) {
            if (Math.abs(arr[hi] - mid) >= Math.abs(arr[lo] - mid)) {
                res[index] = arr[hi];
                hi--;
            } else if (Math.abs(arr[hi] - mid) < Math.abs(arr[lo] - mid)) {
                res[index] = arr[lo];
                lo++;
            }
            k--;
            index++;
        }

        return res;
    }
}
