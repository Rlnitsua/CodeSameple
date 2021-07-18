package rlnitsua.contest;

public class AddRungs {
    public int addRungs(int[] rungs, int dist) {
        int res = 0;
        int start = 0;

        for (int rung : rungs) {
            res += addNum(start, rung, dist);
            start = rung;
        }

        return res;
    }

    private int addNum(int start, int target, int dist) {
        if (target - start <= dist) {
            return 0;
        } else if ((target - start) % dist == 0) {
            return ((target - start) / dist) - 1;
        } else {
            return (target - start) / dist;
        }
    }
}
