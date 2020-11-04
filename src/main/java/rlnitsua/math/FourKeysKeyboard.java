package rlnitsua.math;

public class FourKeysKeyboard {
    public int maxA(int N) {
        if (N <= 4) {
            return N;
        }

        int res = 0;
        for (int i = 1; i <= N - 4; i++) {
            res = Math.max(res, i * (N - 1 - 1));
        }

        return res;
    }
}
