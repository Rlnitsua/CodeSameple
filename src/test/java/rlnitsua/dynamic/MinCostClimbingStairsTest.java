package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MinCostClimbingStairsTest {
    private final int[] cost;
    private final int res;

    public MinCostClimbingStairsTest(int[] cost, int res) {
        this.cost = cost;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{10, 15, 20}, 15},
                {new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6},
        });
    }

    @Test
    public void test() {
        MinCostClimbingStairs demo = new MinCostClimbingStairs();
        assertEquals(res, demo.minCostClimbingStairs(cost));
    }
}