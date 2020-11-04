package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LongestMountaininArrayTest {
    private final int[] A;
    private final int res;

    public LongestMountaininArrayTest(int[] a, int res) {
        A = a;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 1, 4, 7, 3, 2, 5}, 5},
                {new int[]{2, 2, 2}, 0},
                {new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}, 11},
                {new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9}, 3},
        });
    }

    @Test
    public void test() {
        LongestMountaininArray demo = new LongestMountaininArray();
        assertEquals(res, demo.longestMountain(A));
    }
}