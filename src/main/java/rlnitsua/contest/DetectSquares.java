package rlnitsua.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    private final Map<String, Integer> info = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        info.put(getPoint(point), info.getOrDefault(getPoint(point), 0) + 1);
    }

    public int count(int[] point) {
        int count = 0;
        List<int[]> sameColumnPoints = getSameColumnPoints(point);
        List<int[]> sameRowPoints = getSameRowPoints(point);
        if (sameColumnPoints.isEmpty() || sameRowPoints.isEmpty()) {
            return 0;
        }
        for (int[] rowPoint : sameRowPoints) {
            for (int[] columnPoint : sameColumnPoints) {
                if (Math.abs(rowPoint[0] - point[0]) != Math.abs(columnPoint[1] - point[1])) {
                    continue;
                }
                int[] targetPoint = new int[]{columnPoint[0], rowPoint[1]};
                if (info.containsKey(getPoint(targetPoint))) {
                    if (info.containsKey(getPoint(point))) {
                        count += (info.get(getPoint(point))) * info.get(getPoint(rowPoint))
                                * info.get(getPoint(columnPoint)) * info.get(getPoint(targetPoint));
                    } else {
                        count += info.get(getPoint(rowPoint))
                                * info.get(getPoint(columnPoint)) * info.get(getPoint(targetPoint));
                    }
                }
            }
        }

        return count;
    }

    private String getPoint(int[] point) {
        return point[0] + "_" + point[1];
    }

    private List<int[]> getSameColumnPoints(int[] point) {
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : info.entrySet()) {
            int[] targetPoint = getPoint(entry.getKey());
            if (targetPoint[1] == point[1] && targetPoint[0] != point[0]) {
                list.add(targetPoint);
            }
        }
        return list;
    }

    private List<int[]> getSameRowPoints(int[] point) {
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : info.entrySet()) {
            int[] targetPoint = getPoint(entry.getKey());
            if (targetPoint[0] == point[0] && targetPoint[1] != point[1]) {
                list.add(targetPoint);
            }
        }
        return list;
    }

    private int[] getPoint(String point) {
        String[] arr = point.split("_");
        return new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
    }
}
