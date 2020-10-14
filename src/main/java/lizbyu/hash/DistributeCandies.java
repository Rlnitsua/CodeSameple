package lizbyu.hash;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        if (candies == null) {
            return 0;
        }
        int realNum = getRealNum(candies);
        return realNum >= (candies.length / 2) ? (candies.length / 2) : realNum;
    }

    private int getRealNum(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int cancdy : candies) {
            set.add(cancdy);
        }
        return set.size();
    }
}
