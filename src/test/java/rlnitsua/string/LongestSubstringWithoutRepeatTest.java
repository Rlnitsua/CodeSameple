package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestSubstringWithoutRepeatTest {
    private final String s;
    private final int res;

    public LongestSubstringWithoutRepeatTest(String s, int res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abcabcbb", 3},
                {"bbbbb", 1},
                {"pwwkew", 3},
                {"", 0},
        });
    }

    @Test
    public void test() {
        LongestSubstringWithoutRepeat demo = new LongestSubstringWithoutRepeat();
        assertEquals(res, demo.lengthOfLongestSubstring(s));
    }
}