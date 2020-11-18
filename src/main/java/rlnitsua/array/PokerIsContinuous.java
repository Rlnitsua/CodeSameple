package rlnitsua.array;

public class PokerIsContinuous {
    public boolean isContinuous(int[] numbers) {
        int[] backup = new int[14];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num != 0) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            backup[num]++;
        }

        for (int i = 1; i < backup.length; i++) {
            if (backup[i] > 1) {
                return false;
            }
        }

        return max - min >= 4 - backup[0] && max - min <= 4;
    }
}
