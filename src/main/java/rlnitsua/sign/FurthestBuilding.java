package rlnitsua.sign;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 堆的思路解决
 */
public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int sum = 0;
        Queue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int gap = heights[i + 1] - heights[i];
            if (gap > 0) {
                heap.offer(gap);

                if (heap.size() > ladders) {
                    assert !heap.isEmpty();
                    sum += heap.poll();
                }
                if (sum > bricks) {
                    return i;
                }
            }
        }
        return heights.length - 1;
    }
}
