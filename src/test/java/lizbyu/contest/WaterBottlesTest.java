package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WaterBottlesTest {
    private int numBottles;
    private int numExchange;
    private int res;

    public WaterBottlesTest(int numBottles, int numExchange, int res) {
        this.numBottles = numBottles;
        this.numExchange = numExchange;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {9, 3, 13},
                {15, 4, 19},
                {5, 5, 6},
                {2, 3, 2}
        });
    }

    @Test
    public void test() {
        WaterBottles demo = new WaterBottles();
        assertEquals(res, demo.numWaterBottles(numBottles, numExchange));
    }
}