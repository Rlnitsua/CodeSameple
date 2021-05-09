package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxFrequencyTest {
    private final int[] nums;
    private final int k;
    private final int res;

    public MaxFrequencyTest(int[] nums, int k, int res) {
        this.nums = nums;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,4}, 5, 3},
                {new int[]{1,4,8,13}, 5, 2},
                {new int[]{3,9,6}, 2, 1},
        });
    }

    @Test
    public void test() {
        MaxFrequency demo = new MaxFrequency();
        assertEquals(res, demo.maxFrequency(nums, k));
    }
}