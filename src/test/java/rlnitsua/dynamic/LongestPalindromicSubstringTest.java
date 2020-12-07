package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestPalindromicSubstringTest {
    private final String s;
    private final String res;

    public LongestPalindromicSubstringTest(String s, String res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"babad", "bab"},
                {"cbbd", "bb"},
                {"aacabdkacaa", "aca"},
        });
    }

    @Test
    public void test() {
        LongestPalindromicSubstring demo = new LongestPalindromicSubstring();
        assertEquals(res, demo.longestPalindrome(s));
    }
}