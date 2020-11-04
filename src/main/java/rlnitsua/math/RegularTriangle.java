package rlnitsua.math;

import java.util.HashMap;
import java.util.Map;

public class RegularTriangle {
    public int makeEquilateralTriangle(int[] lengths) {
        Map<Integer, Integer> info = new HashMap<>();
        for (int len : lengths) {
            if (info.containsKey(len)) {
                info.put(len, info.get(len) + 1);
            } else {
                info.put(len, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : info.entrySet()) {
            if (entry.getValue() == 3) {
                return 0;
            } else if (entry.getValue() == 2) {
                for (int length : lengths) {
                    if (length > entry.getKey()) {
                        return 1;
                    }
                }
            } else {
                if (info.containsKey(entry.getKey() * 2)) {
                    return 1;
                }
            }
        }

        return 2;
    }
}
