package lizbyu.array;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int positive = 1;
        int arrIndex = 0;

        while (true) {
            if (positive == arr[arrIndex]) {
                positive++;
                if (arrIndex != arr.length - 1) {
                    arrIndex++;
                }
            } else {
                if (k == 1) {
                    return positive;
                } else {
                    positive++;
                    k--;
                }
            }
        }
    }
}
