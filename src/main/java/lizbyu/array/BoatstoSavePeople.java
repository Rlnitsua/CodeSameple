package lizbyu.array;

import java.util.Arrays;

public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 1) {
            return 1;
        }

        Arrays.sort(people);

        boolean[] isUsed = new boolean[people.length];
        int res = 0;
        int lo = 0;
        int hi = people.length - 1;

        while (lo < hi) {
            if (people[lo] + people[hi] <= limit) {
                isUsed[lo++] = true;
                isUsed[hi--] = true;
                res++;
            } else {
                hi--;
            }
        }

        for (int i = 0; i < people.length; i++) {
            if (!isUsed[i]) {
                res++;
            }
        }

        return res;
    }
}
