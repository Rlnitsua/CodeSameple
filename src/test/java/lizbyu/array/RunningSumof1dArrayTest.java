package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class RunningSumof1dArrayTest {
    private int[] nums;
    private int[] res;

    public RunningSumof1dArrayTest(int[] nums, int[] res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}},
                {new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17}},
        });
    }

    @Test
    public void test() {
        RunningSumof1dArray demo = new RunningSumof1dArray();
        assertArrayEquals(res, demo.runningSum(nums));
    }
}