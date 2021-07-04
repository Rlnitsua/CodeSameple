package rlnitsua.contest;

public class CountGoodNumbers {
    private static final int REMAIN = 10_0000_0007;

    public int countGoodNumbers(long n) {
        if (n % 2 == 0) {
            return pow(20, n / 2);
        } else {
            long res = pow(20, n / 2) * 5L;
            res %= REMAIN;
            return (int) res;
        }
    }

    private int pow(int a, long n) {
        if (n == 0) {
            return 1 % REMAIN;
        }
        long ans = 1L;
        long base = a % REMAIN;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = (ans * base) % REMAIN;
            }
            base = (base % REMAIN) * (base % REMAIN) % REMAIN;
            n >>= 1;
        }
        return (int) ans;
    }

}
