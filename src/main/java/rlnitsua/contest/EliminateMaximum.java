package rlnitsua.contest;

import java.util.Arrays;

public class EliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] timeArr = new int[dist.length];
        for (int i = 0; i < timeArr.length; i++) {
            timeArr[i] = (dist[i] % speed[i] == 0)
                    ? (dist[i] / speed[i])
                    : (dist[i] / speed[i]) + 1;
        }
        Arrays.sort(timeArr);
        int count = 0;
        int index = 0;
        while (index < timeArr.length && count < timeArr[index]) {
            count++;
            index++;
        }
        return count;
    }
}
