package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestIncreasingSubsequenceTest {
    private final int[] nums;
    private final int res;

    public LongestIncreasingSubsequenceTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{10,9,2,5,3,7,101,18}, 4},
                {new int[]{1,3,6,7,9,4,10,5,6}, 6},
                {new int[]{7,7,7,7,7,7,7}, 1},
        });
    }

    @Test
    public void test() {
        LongestIncreasingSubsequence demo = new LongestIncreasingSubsequence();
        assertEquals(res, demo.lengthOfLIS(nums));
    }
}