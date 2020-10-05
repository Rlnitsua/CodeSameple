package lizbyu.design;

import java.util.*;

public class SnapshotArray {
    private final Map<Integer, List<int[]>> info;
    private final Map<Integer, Integer> cache;
    private int snapCount = -1;

    public SnapshotArray(int length) {
        info = new HashMap<>();
        cache = new HashMap<>();
    }

    public void set(int index, int val) {
        cache.put(index, val);
    }

    public int snap() {
        snapCount++;

        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (info.containsKey(entry.getKey())) {
                int[] data = new int[2];
                data[0] = entry.getValue();
                data[1] = snapCount;
                info.get(entry.getKey()).add(data);
            } else {
                List<int[]> list = new ArrayList<>();
                int[] data = new int[2];
                data[0] = entry.getValue();
                data[1] = snapCount;
                list.add(data);
                info.put(entry.getKey(), list);
            }
        }

        return snapCount;
    }

    public int get(int index, int snap_id) {
        if (!info.containsKey(index)) {
            return 0;
        } else {
            List<int[]> history = info.get(index);
            for (int i = 0; i < history.size(); i++) {
                if (snap_id == history.get(i)[1]) {
                    return history.get(i)[0];
                } else if (snap_id < history.get(i)[1]) {
                    if (i == 0) {
                        return 0;
                    } else {
                        return history.get(i - 1)[0];
                    }
                }
            }
            return history.get(history.size() - 1)[0];
        }
    }
}
