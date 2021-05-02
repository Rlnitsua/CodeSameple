package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ShiftCharTest {
    private final String s;
    private final String res;

    public ShiftCharTest(String s, String res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"a1c1e1", "abcdef"},
                {"a1b2c3d4e", "abbdcfdhe"},
        });
    }

    @Test
    public void test() {
        ShiftChar demo = new ShiftChar();
        assertEquals(res, demo.replaceDigits(s));
    }
}