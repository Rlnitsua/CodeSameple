package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MagicTowerTest {
    private final int[] nums;
    private final int res;

    public MagicTowerTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{100,100,100,-250,-60,-140,-50,-50,100,150}, 1},
                {new int[]{-200,-300,400,0}, -1},
        });
    }

    @Test
    public void test() {
        MagicTower demo = new MagicTower();
        assertEquals(res, demo.magicTower(nums));
    }
}