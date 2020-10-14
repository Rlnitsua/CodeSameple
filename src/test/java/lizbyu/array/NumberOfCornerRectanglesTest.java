package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberOfCornerRectanglesTest {
    private final int[][] grid;
    private final int res;

    public NumberOfCornerRectanglesTest(int[][] grid, int res) {
        this.grid = grid;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1, 0, 0, 1, 0}, new int[]{0, 0, 1, 0, 1},
                        new int[]{0, 0, 0, 1, 0}, new int[]{1, 0, 1, 0, 1}}, 1},
                {new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}}, 9},
                {new int[][]{new int[]{1, 1, 1, 1}}, 0},
        });
    }

    @Test
    public void test() {
        System.out.println("--- start test");
        NumberOfCornerRectangles demo = new NumberOfCornerRectangles();
        assertEquals(res, demo.countCornerRectangles(grid));
    }
}