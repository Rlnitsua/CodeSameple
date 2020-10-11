package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountNegativeNumbersinaSortedMatrixTest {
    private final int[][] grid;
    private final int res;

    public CountNegativeNumbersinaSortedMatrixTest(int[][] grid, int res) {
        this.grid = grid;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{4,3,2,-1}, new int[]{3,2,1,-1},
                        new int[]{1,1,-1,-2}, new int[]{-1,-1,-2,-3}}, 8},
                {new int[][]{new int[]{3,2}, new int[]{1,0}}, 0},
                {new int[][]{new int[]{1,-1}, new int[]{-1,-1}}, 3},
                {new int[][]{new int[]{-1}}, 1},
        });
    }

    @Test
    public void test() {
        CountNegativeNumbersinaSortedMatrix demom = new CountNegativeNumbersinaSortedMatrix();
        assertEquals(res, demom.countNegatives(grid));
    }
}