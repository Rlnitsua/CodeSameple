package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class InterchangeableRectanglesTest {
    private final int[][] rectangles;
    private final long res;

    public InterchangeableRectanglesTest(int[][] rectangles, long res) {
        this.rectangles = rectangles;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{4, 8}, new int[]{3, 6}, new int[]{10, 20}, new int[]{15, 30}}, 6},
                {new int[][]{new int[]{4, 5}, new int[]{7, 8}}, 0},
        });
    }

    @Test
    public void test() {
        InterchangeableRectangles demo = new InterchangeableRectangles();
        assertEquals(res, demo.interchangeableRectangles(rectangles));
    }
}