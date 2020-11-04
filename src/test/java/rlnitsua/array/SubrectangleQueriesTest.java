package rlnitsua.array;

import rlnitsua.utils.log.LogUtils;
import org.junit.Test;

public class SubrectangleQueriesTest {
    private static final String TAG = "SubrectangleQueriesTest";

    @Test
    public void test() {
        int[][] rectangle = new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
        SubrectangleQueries demo = new SubrectangleQueries(rectangle);
        LogUtils.d(TAG, "getValue(0,2) : " + demo.getValue(0, 2));
        demo.updateSubrectangle(0, 0, 3, 2, 5);
        LogUtils.d(TAG, "getValue(0,2) : " + demo.getValue(0, 2));
        LogUtils.d(TAG, "getValue(3,1) : " + demo.getValue(3, 1));
        demo.updateSubrectangle(3, 0, 3, 2, 10);
        LogUtils.d(TAG, "getValue(3,1) : " + demo.getValue(3, 1));
        LogUtils.d(TAG, "getValue(0,2) : " + demo.getValue(0, 2));
    }
}