package rlnitsua.array;

public class BinarySearch {
    public int search(int v, int[] a) {
        if (a[a.length - 1] < v) {
            return a.length + 1;
        }

        int lo = -1;
        int hi = a.length;

        while (lo + 1 != hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] < v) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return hi + 1;
    }
}
