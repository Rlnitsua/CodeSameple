package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PalindromeNumberTest {
    private final int x;
    private final boolean res;

    public PalindromeNumberTest(int x, boolean res) {
        this.x = x;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {121, true},
                {-121, false},
                {10, false},
        });
    }

    @Test
    public void test() {
        PalindromeNumber demo = new PalindromeNumber();
        assertEquals(res, demo.isPalindrome(x));
    }
}