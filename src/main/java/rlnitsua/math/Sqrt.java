package rlnitsua.math;

public class Sqrt {
    public int sqrt (int x) {
        if (x == 0) {
            return x;
        }

        int l = 0;
        int r = x / 2 + 1;

        while (l + 1 != r) {
            int mid = (l + r) / 2;
            if (mid < x / mid) {
                l = mid;
            } else if (mid > x / mid) {
                r = mid;
            } else {
                return mid;
            }
        }
        return l;
    }
}
