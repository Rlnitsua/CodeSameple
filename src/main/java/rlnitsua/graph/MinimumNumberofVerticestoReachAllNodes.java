package rlnitsua.graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberofVerticestoReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] info = new boolean[n];

        for (List<Integer> edge : edges) {
            info[edge.get(1)] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!info[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
