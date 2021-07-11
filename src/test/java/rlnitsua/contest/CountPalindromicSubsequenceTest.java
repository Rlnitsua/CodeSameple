package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountPalindromicSubsequenceTest {
    private final String s;
    private final int res;

    public CountPalindromicSubsequenceTest(String s, int res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aabca", 3},
                {"adc", 0},
                {"bbcbaba", 4},
        });
    }

    @Test
    public void test() {
        CountPalindromicSubsequence demo = new CountPalindromicSubsequence();
        assertEquals(res, demo.countPalindromicSubsequence(s));
    }
}