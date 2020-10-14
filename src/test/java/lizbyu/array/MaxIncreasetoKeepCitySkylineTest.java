package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaxIncreasetoKeepCitySkylineTest {
    private int[][] grid;
    private int res;

    public MaxIncreasetoKeepCitySkylineTest(int[][] grid, int res) {
        this.grid = grid;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}, 35},
        });
    }

    @Test
    public void test() {
        MaxIncreasetoKeepCitySkyline demo = new MaxIncreasetoKeepCitySkyline();
        assertEquals(res, demo.maxIncreaseKeepingSkyline(grid));
    }
}