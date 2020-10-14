package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SumofAllOddLengthSubarraysTest {
    private final int[] arr;
    private final int res;

    public SumofAllOddLengthSubarraysTest(int[] arr, int res) {
        this.arr = arr;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 2, 5, 3}, 58},
                {new int[]{1, 2}, 3},
                {new int[]{10, 11, 12}, 66},
        });
    }

    @Test
    public void test() {
        SumofAllOddLengthSubarrays demo = new SumofAllOddLengthSubarrays();
        assertEquals(res, demo.sumOddLengthSubarrays(arr));
    }
}