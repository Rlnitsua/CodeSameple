package rlnitsua.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MakeTheStringGreatTest {
    private String s;
    private String res;

    public MakeTheStringGreatTest(String s, String res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"leEeetcode", "leetcode"},
                {"abBAcC", ""},
                {"s", "s"},
        });
    }

    @Test
    public void test() {
        MakeTheStringGreat demo = new MakeTheStringGreat();
        assertEquals(res, demo.makeGood(s));
    }
}