package rlnitsua.contest;

public class ChalkReplacer {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        k = (int) (k % sum);

        int index = 0;

        while (k >= 0) {
            if (k < chalk[index]) {
                return index;
            }
            k -= chalk[index];
            if (index == chalk.length - 1) {
                index = 0;
            } else {
                index++;
            }
        }

        return -1;
    }
}
