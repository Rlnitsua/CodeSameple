package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LargestMagicSquareTest {
    private final int[][] grid;
    private final int res;

    public LargestMagicSquareTest(int[][] grid, int res) {
        this.grid = grid;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{8,1,6}, new int[]{3,5,7},
                        new int[]{4,9,2}, new int[]{7,10,9}}, 3},
                {new int[][]{new int[]{7,1,4,5,6}, new int[]{2,5,1,6,4},
                        new int[]{1,5,4,3,2}, new int[]{1,2,7,3,4}}, 3},
                {new int[][]{new int[]{5,1,3,1}, new int[]{9,3,3,1},
                        new int[]{1,3,3,8}}, 2},

        });
    }

    @Test
    public void test() {
        LargestMagicSquare demo = new LargestMagicSquare();
        assertEquals(res, demo.largestMagicSquare(grid));
    }
}