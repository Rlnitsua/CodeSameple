package rlnitsua.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }

        assert !queue.isEmpty();
        int current = queue.poll();

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (current < temp) {
                queue.offer(temp - current);
            } else {
                queue.offer(current - temp);
            }
            if (queue.isEmpty()) {
                return 0;
            }
            current = queue.poll();
        }

        return current;
    }
}
