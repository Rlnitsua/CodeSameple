package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MergeSortedArrayTest {
    private final int[] a;
    private final int m;
    private final int[] b;
    private final int n;
    private final int[] res;

    public MergeSortedArrayTest(int[] a, int m, int[] b, int n, int[] res) {
        this.a = a;
        this.m = m;
        this.b = b;
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 1, 1, 1}, 3, new int[]{0, 1, 1}, 2,
                        new int[]{0, 1, 1, 2, 3, 1}},
        });
    }

    @Test
    public void test() {
        MergeSortedArray demo = new MergeSortedArray();
        demo.merge(a, m, b, n);
        assertArrayEquals(res, a);
    }
}