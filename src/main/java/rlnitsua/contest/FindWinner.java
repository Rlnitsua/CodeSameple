package rlnitsua.contest;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    public int findTheWinner(int n, int k) {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            data.add(i);
        }
        return findTheWinner(k, data, 0);
    }

    private int findTheWinner(int k, List<Integer> data, int startIndex) {
        if (data.size() == 1) {
            return data.get(0);
        }

        int removeTarget;

        if (startIndex + k - 1 < data.size()) {
            removeTarget = startIndex + k - 1;
        } else {
            removeTarget = (startIndex + k - 1) % data.size();
        }

        int nextIndex = removeTarget;
        if (removeTarget == data.size() - 1) {
            nextIndex = 0;
        }

        data.remove(removeTarget);
        return findTheWinner(k, data, nextIndex);
    }
}
