package rlnitsua.divide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MinimumNumbersofFunctionCallstoMakeTargetArrayTest {
    private int[] nums;
    private int res;

    public MinimumNumbersofFunctionCallstoMakeTargetArrayTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 2}, 3},
                {new int[]{4, 2, 5}, 6},
                {new int[]{3, 2, 2, 4}, 7},
                {new int[]{2, 4, 8, 16}, 8},
        });
    }

    @Test
    public void test() {
        MinimumNumbersofFunctionCallstoMakeTargetArray demo = new MinimumNumbersofFunctionCallstoMakeTargetArray();
        assertEquals(res, demo.minOperations(nums));
    }
}