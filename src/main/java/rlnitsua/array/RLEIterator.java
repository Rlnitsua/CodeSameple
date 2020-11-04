package rlnitsua.array;

public class RLEIterator {
    private int index;
    private int left;
    private final int[] array;

    public RLEIterator(int[] A) {
        this.array = A;
        left = array[0];
    }

    public int next(int n) {
        while (index < array.length) {
            if (left >= n) {
                left -= n;
                return array[index + 1];
            } else {
                n -= left;
                index += 2;
                if (index < array.length) {
                    left = array[index];
                }
            }
        }
        return -1;
    }
}
