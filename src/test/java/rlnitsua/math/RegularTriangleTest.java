package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegularTriangleTest {
    private final int[] lengths;
    private final int res;

    public RegularTriangleTest(int[] lengths, int res) {
        this.lengths = lengths;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3, 7, 5}, 2},
                {new int[]{1, 1, 1}, 0},
                {new int[]{1, 1, 2}, 1},
                {new int[]{1, 2, 3}, 1},
                {new int[]{1, 4, 6, 9, 8}, 1},
        });
    }

    @Test
    public void test() {
        RegularTriangle demo = new RegularTriangle();
        assertEquals(res, demo.makeEquilateralTriangle(lengths));
    }
}