package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinDifferenceTest {
    private final int[] nums;
    private final int[][] queries;
    private final int[] res;

    public MinDifferenceTest(int[] nums, int[][] queries, int[] res) {
        this.nums = nums;
        this.queries = queries;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{10,6,10,4,2},
                                new int[][]{new int[]{0,2}, new int[]{2,3}, new int[]{1,2}, new int[]{3,4}, new int[]{3,4}},
                                new int[]{4,6,4,2,2}},
                        {new int[]{1,3,4,8},
                                new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{2,3}, new int[]{0,3}},
                                new int[]{2,1,4,1}},
                        {new int[]{4,5,2,2,7,10},
                                new int[][]{new int[]{2,3}, new int[]{0,2}, new int[]{0,5}, new int[]{3,5}},
                                new int[]{-1,1,1,3}},
                }
        );
    }

    @Test
    public void test() {
        MinDifference demo = new MinDifference();
        assertArrayEquals(res, demo.minDifference(nums, queries));
    }
}