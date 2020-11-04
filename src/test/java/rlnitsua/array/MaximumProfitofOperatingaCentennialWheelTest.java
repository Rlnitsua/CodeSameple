package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaximumProfitofOperatingaCentennialWheelTest {
    private final int[] customers;
    private final int boardingCost;
    private final int runningCost;
    private final int res;

    public MaximumProfitofOperatingaCentennialWheelTest(int[] customers, int boardingCost, int runningCost, int res) {
        this.customers = customers;
        this.boardingCost = boardingCost;
        this.runningCost = runningCost;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{8, 3}, 5, 6, 3},
                {new int[]{10, 9, 6}, 6, 4, 7},
                {new int[]{3, 4, 0, 5, 1}, 1, 92, -1},
                {new int[]{10, 10, 6, 4, 7}, 3, 8, 9},
        });
    }

    @Test
    public void test() {
        MaximumProfitofOperatingaCentennialWheel demo = new MaximumProfitofOperatingaCentennialWheel();
        assertEquals(res, demo.minOperationsMaxProfit(customers, boardingCost, runningCost));
    }
}