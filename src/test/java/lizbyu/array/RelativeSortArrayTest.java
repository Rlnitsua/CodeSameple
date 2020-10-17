package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RelativeSortArrayTest {
    private final int[] arr1;
    private final int[] arr2;
    private final int[] res;

    public RelativeSortArrayTest(int[] arr1, int[] arr2, int[] res) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6},
                        new int[]{2,2,2,1,4,3,3,9,6,7,19}},
        });
    }

    @Test
    public void test() {
        RelativeSortArray demo = new RelativeSortArray();
        assertArrayEquals(res, demo.relativeSortArray(arr1, arr2));
    }
}