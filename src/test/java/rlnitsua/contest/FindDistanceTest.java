package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindDistanceTest {
    private final int[] nums;
    private final int target;
    private final int start;
    private final int res;

    public FindDistanceTest(int[] nums, int target, int start, int res) {
        this.nums = nums;
        this.target = target;
        this.start = start;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5}, 5, 3, 1},
                {new int[]{1}, 1, 0, 0},
                {new int[]{1,1,1,1,1,1,1,1,1,1}, 1, 0, 0},
        });
    }

    @Test
    public void test() {
        FindDistance demo = new FindDistance();
        assertEquals(res, demo.getMinDistance(nums, target, start));
    }
}