package rlnitsua.sign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FurthestBuildingTest {
    private final int[] heights;
    private final int bricks;
    private final int ladders;
    private final int res;

    public FurthestBuildingTest(int[] heights, int bricks, int ladders, int res) {
        this.heights = heights;
        this.bricks = bricks;
        this.ladders = ladders;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4,2,7,6,9,14,12}, 5, 1, 4},
                {new int[]{4,12,2,7,3,18,20,3,19}, 10, 2, 7},
                {new int[]{14,3,19,3}, 17, 0, 3},
        });
    }

    @Test
    public void test() {
        FurthestBuilding demo = new FurthestBuilding();
        assertEquals(res, demo.furthestBuilding(heights, bricks, ladders));
    }
}