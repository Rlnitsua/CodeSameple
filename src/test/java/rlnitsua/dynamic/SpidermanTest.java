package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SpidermanTest {
    private int[] heights;
    private int k;
    private int x;
    private int y;
    private int res;

    public SpidermanTest(int[] heights, int k, int x, int y, int res) {
        this.heights = heights;
        this.k = k;
        this.x = x;
        this.y = y;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 5, 4, 3, 3, 5}, 3, 10, 6, 16},
        });
    }

    @Test
    public void test() {
        Spiderman demo = new Spiderman();
        assertEquals(res, demo.shuttleInBuildings(heights, k, x, y));
    }
}