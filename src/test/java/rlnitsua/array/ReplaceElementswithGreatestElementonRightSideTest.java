package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ReplaceElementswithGreatestElementonRightSideTest {
    private final int[] arr;
    private final int[] res;

    public ReplaceElementswithGreatestElementonRightSideTest(int[] arr, int[] res) {
        this.arr = arr;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{17, 18, 5, 4, 6, 1}, new int[]{18, 6, 6, 6, 1, -1}},
        });
    }

    @Test
    public void test() {
        ReplaceElementswithGreatestElementonRightSide demo = new ReplaceElementswithGreatestElementonRightSide();
        assertArrayEquals(res, demo.replaceElements(arr));
    }
}