package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReductionOperationsTest {
    private final int[] nums;
    private final int res;

    public ReductionOperationsTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5,1,3}, 3},
                {new int[]{1,1,1}, 0},
                {new int[]{1,1,2,2,3}, 4},
        });
    }

    @Test
    public void test() {
        ReductionOperations demo = new ReductionOperations();
        assertEquals(res, demo.reductionOperations(nums));
    }
}