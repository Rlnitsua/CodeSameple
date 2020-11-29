package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinWindowSubstringTest {
    private final String s;
    private final String t;
    private final String res;

    public MinWindowSubstringTest(String s, String t, String res) {
        this.s = s;
        this.t = t;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ADOBECODEBANC", "ABC", "BANC"},
                {"a", "a", "a"},
                {"abcd", "e", ""},
        });
    }

    @Test
    public void test() {
        MinWindowSubstring demo = new MinWindowSubstring();
        assertEquals(res, demo.minWindow(s, t));
    }
}