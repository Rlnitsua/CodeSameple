package rlnitsua.array;

import java.util.*;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int maxGapCount = 0;
        Map<Integer, Integer> info = new HashMap<>();

        for (List<Integer> row : wall) {
            int gap = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                gap += row.get(i);
                int count = info.getOrDefault(gap, 0) + 1;
                info.put(gap, count);
                maxGapCount = Math.max(maxGapCount, count);
            }
        }

        return wall.size() - maxGapCount;
    }
}
