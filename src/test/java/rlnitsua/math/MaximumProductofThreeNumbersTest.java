package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumProductofThreeNumbersTest {
    private final int[] nums;
    private final int res;

    public MaximumProductofThreeNumbersTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3}, 6},
                {new int[]{1,2,3,4}, 24},
                {new int[]{1,-2,-3,5}, 30},
                {new int[]{1,0,0,300}, 0},
        });
    }

    @Test
    public void test() {
        MaximumProductofThreeNumbers demo = new MaximumProductofThreeNumbers();
        assertEquals(res, demo.maximumProduct(nums));
    }
}