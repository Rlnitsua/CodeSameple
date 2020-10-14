package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountGoodTripletsTest {
    private int[] arr;
    private int a;
    private int b;
    private int c;
    private int res;

    public CountGoodTripletsTest(int[] arr, int a, int b, int c, int res) {
        this.arr = arr;
        this.a = a;
        this.b = b;
        this.c = c;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3, 4},
                {new int[]{1, 1, 2, 2, 3}, 0, 0, 1, 0},
        });
    }

    @Test
    public void test() {
        CountGoodTriplets demo = new CountGoodTriplets();
        assertEquals(res, demo.countGoodTriplets(arr, a, b, c));
    }
}