package rlnitsua.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayofDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> info = new HashMap<>();
        for (int a : A) {
            info.put(a, info.getOrDefault(a, 0) + 1);
        }

        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);

        for (int b : B) {
            if (info.get(b) == 0) {
                continue;
            }

            if (b >= 0) {
                if (info.getOrDefault(2 * b, 0) == 0) {
                    return false;
                }
                info.put(b, info.get(b) - 1);
                info.put(2 * b, info.get(2 * b) - 1);
            } else {
                if (b % 2 != 0) {
                    return false;
                }
                if (info.getOrDefault(b / 2, 0) == 0) {
                    return false;
                }
                info.put(b, info.get(b) - 1);
                info.put(b / 2, info.get(b / 2) - 1);
            }
        }

        return true;
    }
}
