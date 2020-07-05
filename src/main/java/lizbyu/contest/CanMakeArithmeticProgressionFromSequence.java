package lizbyu.contest;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }
        sortArray(arr);
        return isDiffSame(arr);
    }

    private void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private boolean isDiffSame(int[] arr) {
        int diff = arr[0] - arr[1];
        for (int i = 1; i < arr.length - 1; i++) {
            int currentDiff = arr[i] - arr[i + 1];
            if (diff != currentDiff) {
                return false;
            }
        }
        return true;
    }
}
