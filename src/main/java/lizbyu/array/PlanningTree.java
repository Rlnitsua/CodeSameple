package lizbyu.array;

public class PlanningTree {
    public int treePlanning(int[] trees, int d) {
        return treePlanning(trees, d, 0);
    }

    private int treePlanning(int[] trees, int d, int index) {
        if (index == trees.length - 1) {
            return 0;
        }

        int res = 0;
        for (int i = index + 1; i < trees.length; i++) {
            if (trees[i] < trees[index] + d) {
                res++;
            } else {
                return res + treePlanning(trees, d, i);
            }
        }

        return res;
    }
}
