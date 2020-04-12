package lizbyu.contest;

import java.util.HashMap;
import java.util.Map;

public class QueriesonaPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];

        Map<Integer, Integer> info = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            info.put(i, i - 1);
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = info.get(queries[i]);
            updateInfo(queries[i], info);
        }

        return res;
    }

    private void updateInfo(int current, Map<Integer, Integer> info) {
        Integer currentIndex = info.get(current);
        for (Map.Entry<Integer, Integer> entry : info.entrySet()) {
            if (entry.getValue() < currentIndex) {
                info.put(entry.getKey(), entry.getValue() + 1);
            }
        }
        info.put(current, 0);
    }
}
