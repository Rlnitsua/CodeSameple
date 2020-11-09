package rlnitsua.array;

public class MergeSortedArray {
    public void merge(int[] a, int m, int[] b, int n) {
        int aIndex = m - 1;
        int bIndex = n - 1;
        int index = n + m - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            a[index--] = a[aIndex] >= b[bIndex] ? a[aIndex--] : b[bIndex--];
        }

        while (bIndex >= 0) {
            a[index--] = b[bIndex--];
        }
    }
}
