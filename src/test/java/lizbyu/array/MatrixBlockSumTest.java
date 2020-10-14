package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class MatrixBlockSumTest {
    private final int[][] mat;
    private final int K;
    private final int[][] res;

    public MatrixBlockSumTest(int[][] mat, int k, int[][] res) {
        this.mat = mat;
        K = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}, 1,
                        new int[][]{new int[]{12, 21, 16}, new int[]{27, 45, 33}, new int[]{24, 39, 28}}},
                {new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}, 2,
                        new int[][]{new int[]{45, 45, 45}, new int[]{45, 45, 45}, new int[]{45, 45, 45}}},
        });
    }

    @Test
    public void test() {
        MatrixBlockSum demo = new MatrixBlockSum();
        assertArrayEquals(res, demo.matrixBlockSum(mat, K));
    }
}