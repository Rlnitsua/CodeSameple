package lizbyu.array;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorinaCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int end = -1;

        for (int i = rounds.length - 1; i >= 0; i--) {
            if (rounds[i] == start) {
                end = i;
                break;
            }
        }

        int realStart = rounds[end];
        int realEnd = rounds[rounds.length - 1];

        List<Integer> res = new ArrayList<>();
        if (end == rounds.length - 1) {
            res.add(rounds[end]);
        } else if (realStart < realEnd) {
            for (int i = realStart; i <= realEnd; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= realEnd; i++) {
                res.add(i);
            }
            for (int i = realStart; i <= n; i++) {
                res.add(i);
            }
        }

        return res;
    }
}
