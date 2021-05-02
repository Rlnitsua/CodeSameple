package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BuyIceCreamTest {
    private final int[] costs;
    private final int coins;
    private final int res;

    public BuyIceCreamTest(int[] costs, int coins, int res) {
        this.costs = costs;
        this.coins = coins;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,3,2,4,1}, 7, 4},
                {new int[]{10,6,8,7,7,8}, 5, 0},
                {new int[]{1,6,3,1,2,5}, 20, 6},
                {new int[]{10,2,10,10,10,10,8,2,7,8}, 25, 4},
        });
    }

    @Test
    public void test() {
        BuyIceCream demo = new BuyIceCream();
        assertEquals(res, demo.maxIceCream(costs, coins));
    }
}