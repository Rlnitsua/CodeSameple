package rlnitsua.array;

// keep the relative position of odd and even numbers unchanged
public class ReorderArray {
    public void reOrderArray(int[] array) {
        int odd = 0;
        int even = 0;

        while (even < array.length) {
            if (array[even] % 2 != 0) {
                int insertOdd = array[even];
                System.arraycopy(array, odd, array, odd + 1, even - odd);
                array[odd++] = insertOdd;
            }
            even++;
        }
    }
}
