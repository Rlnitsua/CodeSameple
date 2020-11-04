package rlnitsua.math;

public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        int base = a ^ b;
        int carryOver = (a & b) << 1;

        if (carryOver == 0) {
            return base;
        } else {
            return getSum(base, carryOver);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SumofTwoIntegers().getSum(1222, 18));
    }
}
