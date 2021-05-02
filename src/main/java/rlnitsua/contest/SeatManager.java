package rlnitsua.contest;

import java.util.PriorityQueue;

public class SeatManager {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int reserve() {
        return queue.poll();
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}
