package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SqrtTest {
    private final int x;
    private final int res;

    public SqrtTest(int x, int res) {
        this.x = x;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 1},
                {4, 2},
                {9, 3},
                {10, 3},
                {0, 0},
        });
    }

    @Test
    public void test() {
        Sqrt demo = new Sqrt();
        assertEquals(res, demo.sqrt(x));
    }
}