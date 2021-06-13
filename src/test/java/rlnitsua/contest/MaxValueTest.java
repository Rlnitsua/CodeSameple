package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxValueTest {
    private final String n;
    private final int x;
    private final String res;

    public MaxValueTest(String n, int x, String res) {
        this.n = n;
        this.x = x;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"99", 9, "999"},
                {"73", 6, "763"},
                {"-55", 2, "-255"},
                {"-13", 2, "-123"},
                {"-132", 3, "-1323"},
        });
    }

    @Test
    public void test() {
        MaxValue demo = new MaxValue();
        assertEquals(res, demo.maxValue(n, x));
    }
}