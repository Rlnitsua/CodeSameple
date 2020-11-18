package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RotateStringTest {
    private final String a;
    private final String b;
    private final boolean res;

    public RotateStringTest(String a, String b, boolean res) {
        this.a = a;
        this.b = b;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abcde", "cdeab", true},
                {"abcde", "abced", false},
        });
    }

    @Test
    public void test() {
        RotateString demo = new RotateString();
        assertEquals(res, demo.rotateString(a, b));
    }
}