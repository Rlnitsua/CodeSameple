package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RichestCustomerWealthTest {
    private int[][] accounts;
    private int res;

    public RichestCustomerWealthTest(int[][] accounts, int res) {
        this.accounts = accounts;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{
                        new int[]{1,2,3},
                        new int[]{3,2,1},
                }, 6},
                {new int[][]{
                        new int[]{1,5},
                        new int[]{7,3},
                        new int[]{3,5},
                }, 10}
        });
    }

    @Test
    public void test() {
        RichestCustomerWealth demo = new RichestCustomerWealth();
        assertEquals(res, demo.maximumWealth(accounts));
    }
}