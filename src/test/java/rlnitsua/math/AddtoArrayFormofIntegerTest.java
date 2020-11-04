package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AddtoArrayFormofIntegerTest {
    private final int[] a;
    private final int k;
    private final List<Integer> res;

    public AddtoArrayFormofIntegerTest(int[] a, int k, List<Integer> res) {
        this.a = a;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,0,0}, 34, Arrays.asList(1,2,3,4)},
                {new int[]{2,7,4}, 181, Arrays.asList(4,5,5)},
                {new int[]{2,1,5}, 806, Arrays.asList(1,0,2,1)},
                {new int[]{9,9,9,9,9,9,9,9,9,9}, 1, Arrays.asList(1,0,0,0,0,0,0,0,0,0,0)},
        });
    }

    @Test
    public void test() {
        AddtoArrayFormofInteger demo = new AddtoArrayFormofInteger();
        assertEquals(res, demo.addToArrayForm(a, k));
    }
}