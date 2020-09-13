package lizbyu.array;

public class SpecialPositionsinaBinaryMatrix {
    public int numSpecial(int[][] mat) {
        int res = 0;
        boolean[] isBadRow = new boolean[mat.length];
        boolean[] isBadCol = new boolean[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (isBadRow[i] || isBadCol[j]) {
                    continue;
                }

                if (mat[i][j] == 1) {
                    for (int n = 0; n < mat[0].length; n++) {
                        if (n != j && mat[i][n] == 1) {
                            isBadRow[i] = true;
                            break;
                        }
                    }
                    if (isBadRow[i]) {
                        break;
                    }
                    for (int n = 0; n < mat.length; n++) {
                        if (n != i && mat[n][j] == 1) {
                            isBadCol[j] = true;
                            break;
                        }
                    }
                    if (isBadCol[j]) {
                        break;
                    } else {
                        res++;
                        isBadRow[i] = true;
                        isBadCol[j] = true;
                    }
                }
            }
        }
        return res;
    }
}
