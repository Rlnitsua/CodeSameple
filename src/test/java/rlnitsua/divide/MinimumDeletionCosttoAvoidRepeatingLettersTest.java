package rlnitsua.divide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MinimumDeletionCosttoAvoidRepeatingLettersTest {
    private final String s;
    private final int[] cost;
    private final int res;

    public MinimumDeletionCosttoAvoidRepeatingLettersTest(String s, int[] cost, int res) {
        this.s = s;
        this.cost = cost;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abaac", new int[]{1, 2, 3, 4, 5}, 3},
                {"abc", new int[]{1, 2, 3}, 0},
                {"aabaa", new int[]{1, 2, 3, 4, 1}, 2},
        });
    }

    @Test
    public void test() {
        MinimumDeletionCosttoAvoidRepeatingLetters demo = new MinimumDeletionCosttoAvoidRepeatingLetters();
        assertEquals(res, demo.minCost(s, cost));
    }
}