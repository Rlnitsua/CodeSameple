package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RotateGridTest {
    private final int[][] grid;
    private final int k;
    private final int[][] res;

    public RotateGridTest(int[][] grid, int k, int[][] res) {
        this.grid = grid;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{
                        new int[]{1,2,3,4},
                        new int[]{5,6,7,8},
                        new int[]{9,10,11,12},
                        new int[]{13,14,15,16}}, 2,
                new int[][]{
                        new int[]{3,4,8,12},
                        new int[]{2,11,10,16},
                        new int[]{1,7,6,15},
                        new int[]{5,9,13,14}
                }}
        });

//        [[10,1,4,8],[6,6,3,10],[7,4,7,10],[1,10,6,1],[2,1,1,10],[3,8,9,2],[7,1,10,10],[7,1,4,9],[2,2,4,2],[10,7,5,10]]
//        1
    }

    @Test
    public void test() {
        RotateGrid demo = new RotateGrid();
        assertArrayEquals(res, demo.rotateGrid(grid, k));
    }
}