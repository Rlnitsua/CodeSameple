package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseStringTest {
    private final String str;
    private final String res;

    public ReverseStringTest(String str, String res) {
        this.str = str;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abc", "cba"},
        });
    }

    @Test
    public void test() {
        ReverseString demo = new ReverseString();
        assertEquals(res, demo.solve(str));
    }
}