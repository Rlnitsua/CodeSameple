package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuickSortTest {
    private final int[] nums;
    private final int[] res;

    public QuickSortTest(int[] nums, int[] res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,4,2,3,3,4,5}, new int[]{1,2,3,3,4,4,5}},
                {new int[]{1,4,2,2,2,3,45,2}, new int[]{1,2,2,2,2,3,4,45}},
                {new int[]{}, new int[]{}},
        });
    }

    @Test
    public void test() {
        QuickSort demo = new QuickSort();
        demo.sort(nums);
        assertArrayEquals(res, nums);
    }
}