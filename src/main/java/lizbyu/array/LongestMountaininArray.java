package lizbyu.array;

public class LongestMountaininArray{

    public int longestMountain(int[] A) {
        return longestMountain(A, 0, 0);
    }

    private int longestMountain(int[] A, int start, int longest) {
        if (A.length - 2 <= start) {
            return longest;
        }

        if (A[start] >= A[start + 1]) {
            return longestMountain(A, start + 1, longest);
        }

        boolean top = false;
        int current = 0;
        for (int i = start; i < A.length - 1; i++) {
            if (!top) {
                if (A[i] < A[i + 1]) {
                    current++;
                } else if (A[i] > A[i + 1]) {
                    top = true;
                    current++;
                } else {
                    // current = 0
                    return longestMountain(A, i, longest);
                }
            } else {
                if (A[i] < A[i + 1]) {
                    current++;
                    return longestMountain(A, i, Math.max(current, longest));
                } else if (A[i] > A[i + 1]) {
                    current++;
                } else {
                    current++;
                    return longestMountain(A, i, Math.max(current, longest));
                }
            }
        }

        if (!top) {
            current = 0;
        } else {
            current++;
        }

        return Math.max(current, longest);
    }
}
