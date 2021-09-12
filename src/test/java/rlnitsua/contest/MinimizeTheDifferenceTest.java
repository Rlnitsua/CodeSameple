package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinimizeTheDifferenceTest {
    private final int[][] mat;
    private final int target;
    private final int res;

    public MinimizeTheDifferenceTest(int[][] mat, int target, int res) {
        this.mat = mat;
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}}, 13, 0},
                {new int[][]{new int[]{1}, new int[]{2}, new int[]{3}}, 100, 94},
                {new int[][]{new int[]{1,2,9,8,7}}, 6, 1},
        });
    }

    @Test
    public void test() {
        MinimizeTheDifference demo = new MinimizeTheDifference();
        assertEquals(res, demo.minimizeTheDifference(mat, target));
    }
}