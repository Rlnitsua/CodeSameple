package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ThekStrongestValuesinanArrayTest {
    private final int[] arr;
    private final int k;
    private final int[] res;

    public ThekStrongestValuesinanArrayTest(int[] arr, int k, int[] res) {
        this.arr = arr;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 2, new int[]{5, 1}},
                {new int[]{1, 1, 3, 5, 5}, 2, new int[]{5, 5}},
                {new int[]{6, 7, 11, 7, 6, 8}, 5, new int[]{11, 8, 6, 6, 7}},
                {new int[]{6, -3, 7, 2, 11}, 3, new int[]{-3, 11, 2}},
                {new int[]{-7, 22, 17, 3}, 2, new int[]{22, 17}},
        });
    }

    @Test
    public void test() {
        ThekStrongestValuesinanArray demo = new ThekStrongestValuesinanArray();
        assertArrayEquals(res, demo.getStrongest(arr, k));
    }
}