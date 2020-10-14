package lizbyu.dynamic;


public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int current = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] - A[i - 1] == A[i + 1] - A[i]) {
                current++;
                sum += current;
            } else {
                current = 0;
            }
        }
        return sum;
    }
}
