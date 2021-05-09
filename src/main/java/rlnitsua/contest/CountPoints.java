package rlnitsua.contest;

public class CountPoints {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] center = new int[]{queries[i][0], queries[i][1]};
            for (int[] point : points) {
                if (len(point, center) <= queries[i][2]) {
                    res[i]++;
                }
            }
        }

        return res;
    }

    private double len(int[] x, int[] y) {
        return Math.sqrt(((x[0] - y[0]) * (x[0] - y[0]))
                + ((x[1] - y[1]) * (x[1] - y[1])));
    }
}
