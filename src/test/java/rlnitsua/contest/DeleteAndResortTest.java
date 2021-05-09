package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DeleteAndResortTest {
    private final int[] arr;
    private final int res;

    public DeleteAndResortTest(int[] arr, int res) {
        this.arr = arr;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2,2,1,2,1}, 2},
                {new int[]{100,1,1000}, 3},
                {new int[]{1,2,3,4,5}, 5},
                {new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1000}, 6},
        });
    }

    @Test
    public void test() {
        DeleteAndResort demo = new DeleteAndResort();
        assertEquals(res, demo.maximumElementAfterDecrementingAndRearranging(arr));
    }
}