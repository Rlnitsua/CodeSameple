package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReorderArrayTest {
    private final int[] array;
    private final int[] res;

    public ReorderArrayTest(int[] array, int[] res) {
        this.array = array;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5,6}, new int[]{1,3,5,2,4,6}},
        });
    }

    @Test
    public void test() {
        ReorderArray demo = new ReorderArray();
        demo.reOrderArray(array);
        assertArrayEquals(res, array);
    }
}