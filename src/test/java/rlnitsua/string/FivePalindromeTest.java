package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FivePalindromeTest {
    private final String s;
    private final int res;

    public FivePalindromeTest(String s, int res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abcba", 1},
                {"abcbabcccb", 2},
        });
    }

    @Test
    public void test() {
        FivePalindrome demo = new FivePalindrome();
        assertEquals(res, demo.Fivecharacterpalindrome(s));
    }
}