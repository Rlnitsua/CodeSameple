package rlnitsua.contest;

public class MinimumPerimeter {
    public long minimumPerimeter(long neededApples) {
        int maxLevel = 1;
        int lastLevel = maxLevel;
        while (sum(maxLevel) < neededApples) {
            lastLevel = maxLevel;
            maxLevel *= 2;
        }
        int left = lastLevel - 1;
        int right = maxLevel + 1;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            long curr = sum(mid);
            if (curr > neededApples) {
                right = mid;
            } else if (curr < neededApples) {
                left = mid;
            } else {
                return mid * 8L;
            }
        }
        return right * 8L;
    }

    private long sum(long level) {
        return level * level * 8L;
    }
}
