package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxSumOfSubArrayTest {
    private final int[] arr;
    private final int res;

    public MaxSumOfSubArrayTest(int[] arr, int res) {
        this.arr = arr;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,-2,3,5,-2,6,-1}, 12},
        });
    }

    @Test
    public void test() {
        MaxSumOfSubArray demo = new MaxSumOfSubArray();
        assertEquals(res, demo.maxsumofSubarray(arr));
    }
}