package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxDistanceTest {
    private final int[] nums1;
    private final int[] nums2;
    private final int res;

    public MaxDistanceTest(int[] nums1, int[] nums2, int res) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}, 2},
                {new int[]{2,2,2}, new int[]{10,10,1}, 1},
                {new int[]{30,29,19,5}, new int[]{25,25,25,25,25}, 2},
                {new int[]{5,4}, new int[]{3,2}, 0},
        });
    }

    @Test
    public void test() {
        MaxDistance demo = new MaxDistance();
        assertEquals(res, demo.maxDistance(nums1, nums2));
    }
}