package rlnitsua.math;

public class SubtracttheProductandSumofDigitsofanInteger {
    public int subtractProductAndSum(int n) {
        int sub = 1;
        int sum = 0;

        while (n != 0) {
            int temp = n % 10;
            sub *= temp;
            sum += temp;
            n /= 10;
        }

        return sub - sum;
    }
}
