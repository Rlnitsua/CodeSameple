package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumSwapTest {
    private final int num;
    private final int res;

    public MaximumSwapTest(int num, int res) {
        this.num = num;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2736, 7236},
                {9973, 9973},
                {98368, 98863},
        });
    }

    @Test
    public void test() {
        MaximumSwap demo = new MaximumSwap();
        assertEquals(res, demo.maximumSwap(num));
    }
}