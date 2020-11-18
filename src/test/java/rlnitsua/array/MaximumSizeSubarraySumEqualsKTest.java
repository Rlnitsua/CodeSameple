package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumSizeSubarraySumEqualsKTest {
    private final int[] nums;
    private final int k;
    private final int res;

    public MaximumSizeSubarraySumEqualsKTest(int[] nums, int k, int res) {
        this.nums = nums;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,-1,5,-2,3}, 3, 4},
                {new int[]{-2,-1,2,1}, 1, 2},
        });
    }

    @Test
    public void test() {
        MaximumSizeSubarraySumEqualsK demo = new MaximumSizeSubarraySumEqualsK();
        assertEquals(res, demo.maxSubArrayLen(nums, k));
    }
}