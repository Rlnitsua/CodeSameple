package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class KthMissingPositiveNumberTest {
    private final int[] arr;
    private final int k;
    private final int res;

    public KthMissingPositiveNumberTest(int[] arr, int k, int res) {
        this.arr = arr;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2,3,4,7,11}, 5, 9},
                {new int[]{1,2,3,4}, 2, 6},
        });
    }

    @Test
    public void test() {
        KthMissingPositiveNumber demo = new KthMissingPositiveNumber();
        assertEquals(res, demo.findKthPositive(arr, k));
    }
}