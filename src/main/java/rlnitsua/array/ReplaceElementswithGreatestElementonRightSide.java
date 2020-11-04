package rlnitsua.array;

public class ReplaceElementswithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int max = Integer.MIN_VALUE;
        res[res.length - 1] = -1;

        if (res.length == 1) {
            return res;
        }

        for (int i = res.length - 2; i >= 0; i--) {
            max = Math.max(max, arr[i + 1]);
            res[i] = max;
        }

        return res;
    }
}
