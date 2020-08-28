package lizbyu.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RectangleOverlapTest {
    private int[] rec1;
    private int[] rec2;
    private boolean res;

    public RectangleOverlapTest(int[] rec1, int[] rec2, boolean res) {
        this.rec1 = rec1;
        this.rec2 = rec2;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0,0,2,2}, new int[]{1,1,3,3}, true},
                {new int[]{0,0,1,1}, new int[]{1,0,2,1}, false},
        });
    }

    @Test
    public void test() {
        RectangleOverlap demo = new RectangleOverlap();
        assertEquals(res, demo.isRectangleOverlap(rec1, rec2));
    }
}