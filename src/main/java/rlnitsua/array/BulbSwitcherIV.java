package rlnitsua.array;

public class BulbSwitcherIV {
    public int minFlips(String target) {
        int res = 0;
        char last = '0';
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != last) {
                res++;
                last = target.charAt(i);
            }
        }
        return res;
    }
}
