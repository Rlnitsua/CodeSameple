package rlnitsua.design;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberOfOrdersInTheBacklogTest {
    private final int[][] orders;
    private final int res;

    public NumberOfOrdersInTheBacklogTest(int[][] orders, int res) {
        this.orders = orders;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{10,5,0}, new int[]{15,2,1},
                        new int[]{25,1,1}, new int[]{30,4,0}}, 6},
                {new int[][]{new int[]{7,1000000000,1}, new int[]{15,3,0},
                        new int[]{5,999999995,0}, new int[]{5,1,1}}, 999999984},
        });
    }

    @Test
    public void test() {
        NumberOfOrdersInTheBacklog demo = new NumberOfOrdersInTheBacklog();
        assertEquals(res, demo.getNumberOfBacklogOrders(orders));
    }
}