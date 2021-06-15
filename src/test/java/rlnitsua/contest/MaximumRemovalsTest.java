package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumRemovalsTest {
    private final String s;
    private final String p;
    private final int[] removable;
    private final int res;

    public MaximumRemovalsTest(String s, String p, int[] removable, int res) {
        this.s = s;
        this.p = p;
        this.removable = removable;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"qobftgcueho", "obue", new int[]{5,3,0,6,4,9,10,7,2,8}, 7},
                {"abcacb", "ab", new int[]{3,1,0}, 2},
                {"abcbddddd", "abcd", new int[]{3,2,1,4,5,6}, 1},
                {"abcab", "abc", new int[]{0,1,2,3,4}, 0},
        });
    }

    @Test
    public void test() {
        MaximumRemovals demo = new MaximumRemovals();
        assertEquals(res, demo.maximumRemovals(s, p, removable));
    }
}