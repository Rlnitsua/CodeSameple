package lizbyu.array;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveRemain = 0;
        int tenRemain = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveRemain++;
            } else if (bill == 10) {
                if (fiveRemain > 0) {
                    fiveRemain--;
                    tenRemain++;
                } else {
                    return false;
                }
            } else {
                if (tenRemain > 0 && fiveRemain > 0) {
                    tenRemain--;
                    fiveRemain--;
                } else if (fiveRemain >= 3) {
                    fiveRemain -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
