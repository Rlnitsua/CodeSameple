package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScoreAfterFlippingMatrixTest {
    private final int[][] A;
    private final int res;

    public ScoreAfterFlippingMatrixTest(int[][] a, int res) {
        A = a;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{0, 0, 1, 1}, new int[]{1, 0, 1, 0}, new int[]{1, 1, 0, 0}}, 39}
        });
    }

    @Test
    public void test() {
        ScoreAfterFlippingMatrix demo = new ScoreAfterFlippingMatrix();
        assertEquals(res, demo.matrixScore(A));
    }
}