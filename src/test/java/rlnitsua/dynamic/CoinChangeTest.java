package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CoinChangeTest {
    private final int[] coins;
    private final int amount;
    private final int res;

    public CoinChangeTest(int[] coins, int amount, int res) {
        this.coins = coins;
        this.amount = amount;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,5}, 11, 3},
                {new int[]{2}, 3, -1},
                {new int[]{1}, 0, 0},
                {new int[]{1}, 1, 1},
                {new int[]{1}, 2, 2},
        });
    }

    @Test
    public void test() {
        CoinChange demo = new CoinChange();
        assertEquals(res, demo.coinChange(coins, amount));
    }
}