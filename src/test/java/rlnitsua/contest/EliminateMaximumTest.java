package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EliminateMaximumTest {
    private final int[] dist;
    private final int[] speed;
    private final int res;

    public EliminateMaximumTest(int[] dist, int[] speed, int res) {
        this.dist = dist;
        this.speed = speed;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,2,3}, new int[]{1,1,1,1}, 1},
                {new int[]{1,3,4}, new int[]{1,1,1}, 3},
                {new int[]{3,2,4}, new int[]{5,3,2}, 1},
        });
    }

    @Test
    public void test() {
        EliminateMaximum demo = new EliminateMaximum();
        assertEquals(res, demo.eliminateMaximum(dist, speed));
    }
}