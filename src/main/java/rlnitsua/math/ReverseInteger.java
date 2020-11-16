package rlnitsua.math;

public class ReverseInteger {

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int last = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && last > 7)) {
                return 0;
            } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && last < -8)) {
                return 0;
            } else {
                res = res * 10 + last;
            }
        }

        return res;
    }

}
