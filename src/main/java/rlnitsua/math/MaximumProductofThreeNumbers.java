package rlnitsua.math;

public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        int positiveMax = Integer.MIN_VALUE;
        int positiveSecond = Integer.MIN_VALUE;
        int positiveThird = Integer.MIN_VALUE;
        int negativeMax = Integer.MAX_VALUE;
        int negativeSecond = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num >= positiveMax) {
                positiveThird = positiveSecond;
                positiveSecond = positiveMax;
                positiveMax = num;
            } else if (num >= positiveSecond) {
                positiveThird = positiveSecond;
                positiveSecond = num;
            } else if (num >= positiveThird) {
                positiveThird = num;
            }
            if (num <= negativeMax) {
                negativeSecond = negativeMax;
                negativeMax = num;
            } else if (num <= negativeSecond) {
                negativeSecond = num;
            }
        }

        return Math.max(positiveMax * positiveSecond * positiveThird,
                positiveMax * negativeMax * negativeSecond);
    }
}
