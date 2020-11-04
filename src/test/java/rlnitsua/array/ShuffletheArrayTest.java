package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ShuffletheArrayTest {
    private int[] nums;
    private int n;
    private int[] res;

    public ShuffletheArrayTest(int[] nums, int n, int[] res) {
        this.nums = nums;
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 5, 1, 3, 4, 7}, 3, new int[]{2, 3, 5, 4, 1, 7}},
                {new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4, new int[]{1, 4, 2, 3, 3, 2, 4, 1}},
                {new int[]{1, 1, 2, 2}, 2, new int[]{1, 2, 1, 2}},
        });
    }

    @Test
    public void test() {
        ShuffletheArray demo = new ShuffletheArray();
        assertArrayEquals(res, demo.shuffle(nums, n));
    }
}