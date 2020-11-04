package rlnitsua.array;

public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int[] compareArr = new int[calories.length - k + 1];

        for (int i = 0; i < k; i++) {
            compareArr[0] += calories[i];
        }

        for (int i = 1; i <= calories.length - k; i++) {
            compareArr[i] = compareArr[i - 1] - calories[i - 1] + calories[i + k - 1];
        }

        int res = 0;
        for (int compare : compareArr) {
            if (compare > upper) {
                res++;
            } else if (compare < lower) {
                res--;
            }
        }

        return res;
    }
}
