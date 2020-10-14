package lizbyu.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaximumSumObtainedofAnyPermutationTest {
    private final int[] nums;
    private final int[][] requests;
    private final int res;

    public MaximumSumObtainedofAnyPermutationTest(int[] nums, int[][] requests, int res) {
        this.nums = nums;
        this.requests = requests;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[][]{new int[]{1, 3}, new int[]{0, 1}}, 19},
                {new int[]{1, 2, 3, 4, 5, 6}, new int[][]{new int[]{0, 1}}, 11},
                {new int[]{1, 2, 3, 4, 5, 10}, new int[][]{new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 1}}, 47},
        });
    }

    @Test
    public void test() {
        MaximumSumObtainedofAnyPermutation demo = new MaximumSumObtainedofAnyPermutation();
        assertEquals(res, demo.maxSumRangeQuery(nums, requests));
    }
}