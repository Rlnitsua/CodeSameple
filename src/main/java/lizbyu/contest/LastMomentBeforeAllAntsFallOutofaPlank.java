package lizbyu.contest;

public class LastMomentBeforeAllAntsFallOutofaPlank {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lMax = Integer.MIN_VALUE, rMin = Integer.MAX_VALUE;
        for (Integer l : left) {
            lMax = Math.max(lMax, l);
        }
        for (Integer r : right) {
            rMin = Math.min(rMin, r);
        }
        return Math.max(n - rMin, lMax);
    }
}