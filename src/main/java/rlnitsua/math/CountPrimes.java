package rlnitsua.math;

import rlnitsua.utils.log.LogUtils;

public class CountPrimes {
    private static final String TAG = "CountPrimes";

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimeNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimeNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new CountPrimes().countPrimes(2));
    }
}
