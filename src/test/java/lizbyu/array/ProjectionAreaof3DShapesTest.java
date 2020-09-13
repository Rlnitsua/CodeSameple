package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ProjectionAreaof3DShapesTest {
    private final int[][] grid;
    private final int res;

    public ProjectionAreaof3DShapesTest(int[][] grid, int res) {
        this.grid = grid;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{2}}, 5},
                {new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 17},
                {new int[][]{new int[]{1, 0}, new int[]{0, 2}}, 8},
                {new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}}, 14},
                {new int[][]{new int[]{2, 2, 2}, new int[]{2, 1, 2}, new int[]{2, 2, 2}}, 21},
        });
    }

    @Test
    public void test() {
        ProjectionAreaof3DShapes demo = new ProjectionAreaof3DShapes();
        assertEquals(res, demo.projectionArea(grid));
    }
}