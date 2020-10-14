package lizbyu.math;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthlargestNumberinMultiplicationTable {
    private static final String TAG = "KthlargestNumberinMultiplicationTable";

    public int findKthNumber(int m, int n, int k) {
        List<Integer> numList = getPosition(m, n);
        Collections.sort(numList);
        return numList.get(k - 1);
    }

    private List<Integer> getPosition(int m, int n) {
        List<Integer> numList = new ArrayList<>();
        for (int row = 1; row <= m; row++) {
            for (int column = 1; column <= n; column++) {
                numList.add(row + ((column - 1) * row));
            }
        }
        return numList;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, new KthlargestNumberinMultiplicationTable().findKthNumber(3, 3, 5));
        LogUtils.d(TAG, new KthlargestNumberinMultiplicationTable().findKthNumber(2, 3, 6));
    }
}
