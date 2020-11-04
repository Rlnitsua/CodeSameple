package rlnitsua.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] matrixElement : matrix) {
            int minVal = Integer.MAX_VALUE;
            int minValColumnIndex = -1;

            for (int column = 0; column < matrixElement.length; column++) {
                if (matrixElement[column] < minVal) {
                    minVal = matrixElement[column];
                    minValColumnIndex = column;
                }
            }

            int maxVal;
            if (map.containsKey(minValColumnIndex)) {
                maxVal = map.get(minValColumnIndex);

            } else {
                maxVal = calculateMaxVal(matrix, minValColumnIndex);
                map.put(minValColumnIndex, maxVal);
            }

            if (matrixElement[minValColumnIndex] == maxVal) {
                res.add(matrixElement[minValColumnIndex]);
            }
        }

        return res;
    }

    private int calculateMaxVal(int[][] matrix, int minValColumnIndex) {
        int maxVal = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            int currentVal = matrix[row][minValColumnIndex];
            maxVal = (maxVal > currentVal) ? maxVal : currentVal;
        }
        return maxVal;
    }
}
