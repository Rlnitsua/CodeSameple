package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class JumpTest {
    private final int[] obstacles;
    private final int res;

    public JumpTest(int[] obstacles, int res) {
        this.obstacles = obstacles;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0,1,2,3,0}, 2},
                {new int[]{0,1,1,3,3,0}, 0},
                {new int[]{0,2,1,0,3,0}, 2},
        });
    }

    @Test
    public void test() {
        Jump demo = new Jump();
        assertEquals(res, demo.minSideJumps(obstacles));
    }
}