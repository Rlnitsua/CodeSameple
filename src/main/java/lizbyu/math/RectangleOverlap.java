package lizbyu.math;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isOverlap(rec1, rec2) || isOverlap(rec2, rec1);
    }

    private boolean isOverlap(int[] rec1, int[] rec2) {
        boolean first = (rec1[2] > rec2[2] && rec1[3] > rec2[3])
                && (rec1[0] < rec2[0] && rec1[1] < rec2[1]);
        boolean second = (rec1[0] < rec2[2] && rec1[1] < rec2[3])
                && (rec1[2] > rec2[0] && rec1[3] > rec2[1]);
        return first || second;
    }
}
