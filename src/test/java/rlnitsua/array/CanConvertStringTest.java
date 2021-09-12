package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CanConvertStringTest {
    private final String s;
    private final String t;
    private final int k;
    private final boolean res;

    public CanConvertStringTest(String s, String t, int k, boolean res) {
        this.s = s;
        this.t = t;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"input", "ouput", 9, true},
                {"iqssxdlb", "dyuqrwyr", 40, true},
                {"atmtxzjkz", "tvbtjhvjd", 35, false},
                {"abc", "bcd", 10, false},
                {"aab", "bbb", 27, true},
        });
    }

    @Test
    public void test() {
        CanConvertString demo = new CanConvertString();
        assertEquals(res, demo.canConvertString(s, t, k));
    }
}