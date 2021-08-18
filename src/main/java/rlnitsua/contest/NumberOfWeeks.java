package rlnitsua.contest;

import java.util.PriorityQueue;

public class NumberOfWeeks {
    public long numberOfWeeks(int[] milestones) {
        long res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int milestone : milestones) {
            if (milestone != 0) {
                queue.offer(milestone);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return res + 1;
            }
            int max = queue.poll();
            assert !queue.isEmpty();
            int second = queue.poll();
            if (queue.isEmpty()) {
                if (max == second) {
                    return res + (second * 2L);
                } else {
                    return res + (second * 2L) + 1;
                }
            } else {
                int third = queue.peek();
                int gain = second - third + 1;
                if (max - gain != 0) {
                    queue.offer(max - gain);
                }
                if (second - gain != 0) {
                    queue.offer(second - gain);
                }
                res += gain * 2L;
            }
        }

        return res;
    }
}
