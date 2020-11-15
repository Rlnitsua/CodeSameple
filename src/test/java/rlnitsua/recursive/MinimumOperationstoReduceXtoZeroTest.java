package rlnitsua.recursive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinimumOperationstoReduceXtoZeroTest {
    private final int[] nums;
    private final int x;
    private final int res;

    public MinimumOperationstoReduceXtoZeroTest(int[] nums, int x, int res) {
        this.nums = nums;
        this.x = x;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,4,2,3}, 5, 2},
                {new int[]{5,6,7,8,9}, 4, -1},
                {new int[]{3,2,20,1,1,3}, 10, 5},
                {new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365, 16},
        });
    }

    @Test
    public void test() {
        MinimumOperationstoReduceXtoZero demo = new MinimumOperationstoReduceXtoZero();
        assertEquals(res, demo.minOperations(nums, x));
    }
}