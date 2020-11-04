package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaximumNumberofCoinsYouCanGetTest {
    private int[] piles;
    private int res;

    public MaximumNumberofCoinsYouCanGetTest(int[] piles, int res) {
        this.piles = piles;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 4, 1, 2, 7, 8}, 9},
                {new int[]{2, 4, 5}, 4},
                {new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}, 18},
        });
    }

    @Test
    public void test() {
        MaximumNumberofCoinsYouCanGet demo = new MaximumNumberofCoinsYouCanGet();
        assertEquals(res, demo.maxCoins(piles));
    }
}