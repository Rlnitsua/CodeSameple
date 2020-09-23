package lizbyu.array;

public class SumofAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int select = 1;

        while (select <= arr.length) {
            if (select == arr.length) {
                for (int num : arr) {
                    sum += num;
                }
            } else {
                int[] times = calculateTimes(arr.length, select);
                for (int i = 0; i < arr.length; i++) {
                    sum += arr[i] * times[i];
                }
            }
            select += 2;
        }

        return sum;
    }

    private int[] calculateTimes(int arrLen, int select) {
        int[] times = new int[arrLen];
        int index = 0;
        int time = 1;

        while (index < arrLen) {
            if (index <= (arrLen - 1) / 2) {
                times[index] = time;
                if (index < arrLen - select && time < select) {
                    time++;
                }
            } else {
                times[index] = times[arrLen - 1 - index];
            }
            index++;
        }
        return times;
    }
}
