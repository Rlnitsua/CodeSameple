package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindWinnerTest {
    private final int n;
    private final int k;
    private final int res;

    public FindWinnerTest(int n, int k, int res) {
        this.n = n;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 2, 3},
                {6, 5, 1},
        });
    }

    @Test
    public void test() {
        FindWinner demo = new FindWinner();
        assertEquals(res, demo.findTheWinner(n, k));
    }
}