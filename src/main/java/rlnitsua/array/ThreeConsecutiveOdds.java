package rlnitsua.array;

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int times = 0;
        for (int value : arr) {
            if (value % 2 != 0) {
                times++;
            } else {
                times = 0;
            }
            if (times == 3) {
                return true;
            }
        }
        return false;
    }
}
