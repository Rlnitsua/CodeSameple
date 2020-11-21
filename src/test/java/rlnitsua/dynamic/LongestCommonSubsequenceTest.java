package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestCommonSubsequenceTest {
    private final String text1;
    private final String text2;
    private final int res;

    public LongestCommonSubsequenceTest(String text1, String text2, int res) {
        this.text1 = text1;
        this.text2 = text2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abcde", "ace", 3},
                {"abc", "abc", 3},
                {"abc", "def", 0},
        });
    }

    @Test
    public void test() {
        LongestCommonSubsequence demo = new LongestCommonSubsequence();
        assertEquals(res, demo.longestCommonSubsequence(text1, text2));
    }
}