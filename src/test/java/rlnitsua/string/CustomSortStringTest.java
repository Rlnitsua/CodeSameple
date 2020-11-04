package rlnitsua.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CustomSortStringTest {
    private String S;
    private String T;
    private String res;

    public CustomSortStringTest(String s, String t, String res) {
        S = s;
        T = t;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"cba", "abcd", "cbad"},
        });
    }

    @Test
    public void test() {
        CustomSortString demo = new CustomSortString();
        assertEquals(res, demo.customSortString(S, T));
    }
}