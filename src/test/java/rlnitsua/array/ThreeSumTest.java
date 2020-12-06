package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ThreeSumTest {
    private final int[] nums;
    private final List<List<Integer>> res;

    public ThreeSumTest(int[] nums, List<List<Integer>> res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{-1,0,1,2,-1,-4},
                        Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1))},
        });
    }

    @Test
    public void test() {
        ThreeSum demo = new ThreeSum();
        assertEquals(res, demo.threeSum(nums));
    }
}