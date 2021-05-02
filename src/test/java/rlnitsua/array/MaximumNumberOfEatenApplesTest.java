package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumNumberOfEatenApplesTest {
    private final int[] apples;
    private final int[] days;
    private final int res;

    public MaximumNumberOfEatenApplesTest(int[] apples, int[] days, int res) {
        this.apples = apples;
        this.days = days;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                {new int[]{1, 1, 0}, new int[]{1, 1, 0}, 2},
//                {new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}, 7},
                {new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}, 5},
        });
    }

    @Test
    public void test() {
        MaximumNumberOfEatenApples demo = new MaximumNumberOfEatenApples();
        assertEquals(res, demo.eatenApples(apples, days));
    }
}