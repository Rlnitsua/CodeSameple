package rlnitsua.heap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class KthLargestElementInAnArrayTest {
    private final int[] nums;
    private final int k;
    private final int res;

    public KthLargestElementInAnArrayTest(int[] nums, int k, int res) {
        this.nums = nums;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3,2,1,5,6,4}, 2, 5},
                {new int[]{3,2,3,1,2,4,5,5,6}, 4, 4},
        });
    }

    @Test
    public void test() {
        KthLargestElementInAnArray demo = new KthLargestElementInAnArray();
        assertEquals(res, demo.findKthLargest(nums, k));
    }
}