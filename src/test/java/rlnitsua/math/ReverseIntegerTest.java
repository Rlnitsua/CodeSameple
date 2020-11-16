package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseIntegerTest {
    private final int x;
    private final int res;

    public ReverseIntegerTest(int x, int res) {
        this.x = x;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {12345, 54321},
                {-12345, -54321},
                {123456789, 987654321},
                {1234567899, 0},
        });
    }

    @Test
    public void test() {
        ReverseInteger demo = new ReverseInteger();
        assertEquals(res, demo.reverse(x));
    }
}