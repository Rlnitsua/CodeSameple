package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestCommonSubstringTest {
    private final String str1;
    private final String str2;
    private final String res;

    public LongestCommonSubstringTest(String str1, String str2, String res) {
        this.str1 = str1;
        this.str2 = str2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1AB2345CD", "12345EF", "2345"},
        });
    }

    @Test
    public void test() {
        LongestCommonSubstring demo = new LongestCommonSubstring();
        assertEquals(res, demo.LCS(str1, str2));
    }
}