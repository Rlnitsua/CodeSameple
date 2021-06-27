package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CanBeIncreasingTest {
    private final int[] nums;
    private final boolean res;

    public CanBeIncreasingTest(int[] nums, boolean res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,10,5,7}, true},
                {new int[]{2,3,1,2}, false},
                {new int[]{1,1,1}, false},
                {new int[]{1,2,3}, true},
                {new int[]{105,924,32,968}, true},
        });
    }

    @Test
    public void test() {
        CanBeIncreasing demo = new CanBeIncreasing();
        assertEquals(res, demo.canBeIncreasing(nums));
    }
}