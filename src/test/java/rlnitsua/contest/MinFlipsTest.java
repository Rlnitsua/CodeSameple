package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinFlipsTest {
    private final String s;
    private final int res;

    public MinFlipsTest(String s, int res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"111000", 2},
                {"010", 0},
                {"1110", 1},
                {"01001001101", 2},
        });
    }

    @Test
    public void test() {
        MinFlips demo = new MinFlips();
        assertEquals(res, demo.minFlips(s));
    }
}