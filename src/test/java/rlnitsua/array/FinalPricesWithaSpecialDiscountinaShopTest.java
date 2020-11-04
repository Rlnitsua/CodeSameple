package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class FinalPricesWithaSpecialDiscountinaShopTest {
    private final int[] prices;
    private final int[] res;

    public FinalPricesWithaSpecialDiscountinaShopTest(int[] prices, int[] res) {
        this.prices = prices;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{8, 4, 6, 2, 3}, new int[]{4, 2, 4, 2, 3}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{10, 1, 1, 6}, new int[]{9, 0, 1, 6}},
        });
    }

    @Test
    public void test() {
        FinalPricesWithaSpecialDiscountinaShop demo = new FinalPricesWithaSpecialDiscountinaShop();
        assertArrayEquals(res, demo.finalPrices(prices));
    }
}