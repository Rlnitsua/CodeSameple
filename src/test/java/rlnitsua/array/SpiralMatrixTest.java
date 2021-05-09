package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SpiralMatrixTest {
    private final int num;
    private final int x;
    private final int y;
    private final int res;

    public SpiralMatrixTest(int num, int x, int y, int res) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 0, 2, 3},
                {4, 1, 2, 5},
                {5, 2, 0, 6},
                {7, 1, 2, 8},
                {7, 3, 3, 4},
                {7, 4, 4, 9},
        });
    }

    @Test
    public void test() {
        SpiralMatrix demo = new SpiralMatrix();
        assertEquals(res, demo.orchestraLayout(num, x, y));
    }
}