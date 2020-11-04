package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    private static final String TAG = "PascalsTriangleII";

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
//		LogUtils.d(TAG, new PascalsTriangleII().getRow(0));
//		LogUtils.d(TAG, new PascalsTriangleII().getRow(1));
        LogUtils.d(TAG, new PascalsTriangleII().getRow(2));
//		LogUtils.d(TAG, new PascalsTriangleII().getRow(3));
//		LogUtils.d(TAG, new PascalsTriangleII().getRow(4));
//		LogUtils.d(TAG, new PascalsTriangleII().getRow(5));
    }
}
