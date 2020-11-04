package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PlalindromeSumTest {
    private final String s;
    private final long res;

    public PlalindromeSumTest(String s, long res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"bacbdab", 12},
        });
    }

    @Test
    public void test() {
        PlalindromeSum demo = new PlalindromeSum();
        assertEquals(res, demo.suffixQuery(s));
    }
}