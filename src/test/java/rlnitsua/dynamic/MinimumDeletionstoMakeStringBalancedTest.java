package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinimumDeletionstoMakeStringBalancedTest {
    private final String s;
    private final int res;

    public MinimumDeletionstoMakeStringBalancedTest(String s, int res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aababbab", 2},
                {"bbaaaaabb", 2},
        });
    }

    @Test
    public void test() {
        MinimumDeletionstoMakeStringBalanced demo = new MinimumDeletionstoMakeStringBalanced();
        assertEquals(res, demo.minimumDeletions(s));
    }
}