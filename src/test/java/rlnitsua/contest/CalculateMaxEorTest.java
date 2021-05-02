package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculateMaxEorTest {
    private final int[] nums;
    private final int maximumBit;
    private final int[] res;

    public CalculateMaxEorTest(int[] nums, int maximumBit, int[] res) {
        this.nums = nums;
        this.maximumBit = maximumBit;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0,1,1,3}, 2, new int[]{0,3,2,3}},
                {new int[]{2,3,4,7}, 3, new int[]{5,2,6,5}},
                {new int[]{0,1,2,2,5,7}, 3, new int[]{4,3,6,4,6,7}},
        });
    }

    @Test
    public void test() {
        CalculateMaxEor demo = new CalculateMaxEor();
        assertArrayEquals(res, demo.getMaximumXor(nums, maximumBit));
    }
}