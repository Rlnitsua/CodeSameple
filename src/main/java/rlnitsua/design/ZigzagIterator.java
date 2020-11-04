package rlnitsua.design;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ZigzagIterator {
    private Queue<Integer> queue = new LinkedBlockingQueue<>();

    // o(n)
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        for (int i = 0; i < Math.max(v1.size(), v2.size()); i++) {
            if (i < v1.size()) {
                queue.offer(v1.get(i));
            }
            if (i < v2.size()) {
                queue.offer(v2.get(i));
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }
}