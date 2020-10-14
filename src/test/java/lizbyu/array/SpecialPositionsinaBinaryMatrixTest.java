package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SpecialPositionsinaBinaryMatrixTest {
    private final int[][] mat;
    private final int res;

    public SpecialPositionsinaBinaryMatrixTest(int[][] mat, int res) {
        this.mat = mat;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1, 0, 0}, new int[]{0, 0, 1}, new int[]{1, 0, 0}}, 1},
                {new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}}, 3},
                {new int[][]{new int[]{0, 0, 0, 1}, new int[]{1, 0, 0, 0}, new int[]{0, 1, 1, 0}, new int[]{0, 0, 0, 0}}, 2},
                {new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{1, 0, 0, 0, 0},
                        new int[]{0, 1, 0, 0, 0}, new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 1, 1}}, 3},
        });
    }

    @Test
    public void test() {
        SpecialPositionsinaBinaryMatrix demo = new SpecialPositionsinaBinaryMatrix();
        assertEquals(res, demo.numSpecial(mat));
    }
}