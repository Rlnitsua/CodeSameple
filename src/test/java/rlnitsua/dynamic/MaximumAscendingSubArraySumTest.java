package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumAscendingSubArraySumTest {
    private final int[] nums;
    private final int res;

    public MaximumAscendingSubArraySumTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{10,20,30,5,10,50}, 65},
                {new int[]{10,20,30,40,50}, 150},
                {new int[]{12,17,15,13,10,11,12}, 33},
                {new int[]{100,10,1}, 100},
        });
    }

    @Test
    public void test() {
        MaximumAscendingSubArraySum demo = new MaximumAscendingSubArraySum();
        assertEquals(res, demo.maxAscendingSum(nums));
    }
}