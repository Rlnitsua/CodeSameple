package rlnitsua.math;

import java.util.PriorityQueue;

public class MinimumCosttoConnectSticks {
    public int connectSticks(int[] sticks) {
        int res = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) {
            pq.add(s);
        }

        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            res += sum;
            pq.add(sum);
        }

        return res;
    }

}
