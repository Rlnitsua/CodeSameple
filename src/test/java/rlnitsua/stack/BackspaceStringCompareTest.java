package rlnitsua.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BackspaceStringCompareTest {
    private final String S;
    private final String T;
    private final boolean res;

    public BackspaceStringCompareTest(String s, String t, boolean res) {
        S = s;
        T = t;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ab#c", "ad#c", true},
                {"ab##", "c#d#", true},
                {"a##c", "#a#c", true},
                {"a#c", "b", false},
                {"y#fo##f", "y#f#o##f", true},
        });
    }

    @Test
    public void test() {
        BackspaceStringCompare demo = new BackspaceStringCompare();
        assertEquals(res, demo.backspaceCompare(S, T));
    }
}