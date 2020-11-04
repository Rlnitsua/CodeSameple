package rlnitsua.math;

public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int length = String.valueOf(N).length();
        int[] arr = initArr(D);

        int res = 0;
        for (int i = 1; i < length; i++) {
            res += Math.pow(arr.length, i);
        }

        res += calculateEqualNum(N, arr);

        return res;
    }

    private int[] initArr(String[] d) {
        int[] arr = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            arr[i] = Integer.parseInt(d[i]);
        }
        return arr;
    }

    private int calculateEqualNum(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }

        int num = 0;
        int length = String.valueOf(n).length();
        int currentDigit = (int) (n / Math.pow(10, length - 1));

        for (int a : arr) {
            if (currentDigit > a) {
                num += Math.pow(arr.length, length - 1);
            } else if (currentDigit == a) {
                if (length == 1) {
                    num += 1;
                } else if (n / Math.pow(10, length - 2) % 10 == 0) {
                    break;
                } else {
                    num += calculateEqualNum((int) (n % Math.pow(10, length - 1)), arr);
                }
            } else {
                break;
            }
        }

        return num;
    }
}
