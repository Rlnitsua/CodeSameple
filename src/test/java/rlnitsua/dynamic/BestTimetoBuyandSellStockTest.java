package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BestTimetoBuyandSellStockTest {
    private final int[] prices;
    private final int res;

    public BestTimetoBuyandSellStockTest(int[] prices, int res) {
        this.prices = prices;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{7,1,5,3,6,4}, 5},
                {new int[]{7,6,4,3,1}, 0},
        });
    }

    @Test
    public void test() {
        BestTimetoBuyandSellStock demo = new BestTimetoBuyandSellStock();
        assertEquals(res, demo.maxProfit(prices));
    }
}