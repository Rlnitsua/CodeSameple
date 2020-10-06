package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ArrayofDoubledPairsTest {
    private final int[] A;
    private final boolean res;

    public ArrayofDoubledPairsTest(int[] a, boolean res) {
        A = a;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3,1,3,6}, false},
                {new int[]{2,1,2,6}, false},
                {new int[]{4,-2,2,-4}, true},
                {new int[]{1,2,4,16,8,4}, false},
        });
    }

    @Test
    public void test() {
        ArrayofDoubledPairs demo = new ArrayofDoubledPairs();
        assertEquals(res, demo.canReorderDoubled(A));
    }
}