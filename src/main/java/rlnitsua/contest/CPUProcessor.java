package rlnitsua.contest;

import java.util.HashMap;
import java.util.Map;

public class CPUProcessor {
    private int[] res;

    public int[] getOrder(int[][] tasks) {
        res = new int[tasks.length];

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(i, tasks[i]);
        }
        traversal(map, 0, 0);

        return res;
    }

    private void traversal(Map<Integer, int[]> map, int index, int startTime) {
        if (map.size() == 0) {
            return;
        }

        Map<Integer, int[]> beforeMap = new HashMap<>();
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int currStartTime = entry.getValue()[0];
            if (currStartTime <= startTime) {
                beforeMap.put(entry.getKey(), entry.getValue());
            }
        }

        int taskID;
        if (beforeMap.isEmpty()) {
            taskID = getEarliestAndShortestAndSmall(map);
            startTime = map.get(taskID)[0];
            int processTime = map.get(taskID)[1];
            res[index] = taskID;
            map.remove(taskID);
            traversal(map, index + 1, startTime + processTime);
        } else {
            taskID = getShortestAndSmall(beforeMap);
            int processTime = map.get(taskID)[1];
            res[index] = taskID;
            map.remove(taskID);
            traversal(map, index + 1, startTime + processTime);
        }
    }

    private int getEarliestAndShortestAndSmall(Map<Integer, int[]> map) {
        int earliestTime = Integer.MAX_VALUE;
        Map<Integer, int[]> earliestMap = new HashMap<>();

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int startTime = entry.getValue()[0];
            if (startTime < earliestTime) {
                earliestTime = startTime;
                earliestMap.clear();
                earliestMap.put(entry.getKey(), entry.getValue());
            } else if (startTime == earliestTime) {
                earliestMap.put(entry.getKey(), entry.getValue());
            }
        }

        return getShortestAndSmall(earliestMap);
    }

    private int getShortestAndSmall(Map<Integer, int[]> map) {
        Map<Integer, int[]> targetMap = new HashMap<>();
        int shortest = Integer.MAX_VALUE;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int processTime = entry.getValue()[1];
            if (processTime < shortest) {
                shortest = processTime;
                targetMap.clear();
                targetMap.put(entry.getKey(), entry.getValue());
            } else if (processTime == shortest) {
                targetMap.put(entry.getKey(), entry.getValue());
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : targetMap.entrySet()) {
            int currIndex = entry.getKey();
            if (currIndex < minIndex) {
                minIndex = currIndex;
            }
        }
        return minIndex;
    }
}
