package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindMinIntervalTest {
    private final int[][] intervals;
    private final int[] queries;
    private final int[] res;

    public FindMinIntervalTest(int[][] intervals, int[] queries, int[] res) {
        this.intervals = intervals;
        this.queries = queries;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1,4},new int[]{2,4},new int[]{3,6},new int[]{4,4},},
                        new int[]{2,3,4,5}, new int[]{3,3,1,4}},
                {new int[][]{new int[]{2,3},new int[]{2,5},new int[]{1,8},new int[]{20,25},},
                        new int[]{2,19,5,22}, new int[]{2,-1,4,6}},
        });
    }

    @Test
    public void test() {
        FindMinInterval demo = new FindMinInterval();
        assertArrayEquals(res, demo.minInterval(intervals, queries));
    }
}