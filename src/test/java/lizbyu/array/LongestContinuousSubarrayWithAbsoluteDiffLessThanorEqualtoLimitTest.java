package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimitTest {
    private final int[] nums;
    private final int limit;
    private final int res;

    public LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimitTest(int[] nums, int limit, int res) {
        this.nums = nums;
        this.limit = limit;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{8,2,4,7}, 4, 2},
                {new int[]{10,1,2,4,7,2}, 5, 4},
                {new int[]{4,2,2,2,4,4,2,2}, 0, 3},
        });
    }

    @Test
    public void test() {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit demo = new LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit();
        assertEquals(res, demo.longestSubarray(nums, limit));
    }
}