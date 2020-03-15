package lizbyu.contest;

import lizbyu.utils.log.LogUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LuckyNumbersinaMatrixTest {
    public static final String TAG = "LuckyNumbersinaMatrixTest";

    private int[][] matrix;
    private List<Integer> res;

    public LuckyNumbersinaMatrixTest(int[][] matrix, List<Integer> res) {
        this.matrix = matrix;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> preparData() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{3,7,8}, {9,11,13}, {15,16,17}}, Arrays.asList(15)},
                {new int[][]{{1,10,4,2}, {9,3,8,7}, {15,16,17,12}}, Arrays.asList(12)},
                {new int[][]{{7,8}, {1,2}}, Arrays.asList(7)}
        });
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void luckyNumbers() {
        LuckyNumbersinaMatrix luckyNumbersinaMatrixmatrix = new LuckyNumbersinaMatrix();
        LogUtils.d(TAG, "calculate res : " + luckyNumbersinaMatrixmatrix.luckyNumbers(matrix));
        LogUtils.d(TAG, "answer is : " + res);
        assertTrue(res.equals(luckyNumbersinaMatrixmatrix.luckyNumbers(matrix)));
    }
}