package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestCommonPrefixTest {
    private final String[] strs;
    private final String res;

    public LongestCommonPrefixTest(String[] strs, String res) {
        this.strs = strs;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"flower","flow","flight"}, "fl"},
                {new String[]{"dog","racecar","car"}, ""},
        });
    }

    @Test
    public void test() {
        LongestCommonPrefix demo = new LongestCommonPrefix();
        assertEquals(res, demo.longestCommonPrefix(strs));
    }
}