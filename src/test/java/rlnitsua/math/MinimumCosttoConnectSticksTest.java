package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MinimumCosttoConnectSticksTest {
    private final int[] sticks;
    private final int res;

    public MinimumCosttoConnectSticksTest(int[] sticks, int res) {
        this.sticks = sticks;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009}, 151646},
        });
    }

    @Test
    public void test() {
        MinimumCosttoConnectSticks demo = new MinimumCosttoConnectSticks();
        assertEquals(res, demo.connectSticks(sticks));
    }
}