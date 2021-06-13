package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindRotationTest {
    private final int[][] mat;
    private final int[][] target;
    private final boolean res;

    public FindRotationTest(int[][] mat, int[][] target, boolean res) {
        this.mat = mat;
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    new int[][]{new int[]{0,1}, new int[]{1,0}},
                    new int[][]{new int[]{1,0}, new int[]{0,1}},
                    true
                },
                {
                    new int[][]{new int[]{0,1}, new int[]{1,1}},
                    new int[][]{new int[]{1,0}, new int[]{0,1}},
                    false
                },
                {
                    new int[][]{new int[]{0,0,0}, new int[]{0,1,0}, new int[]{1,1,1}},
                    new int[][]{new int[]{1,1,1}, new int[]{0,1,0}, new int[]{0,0,0}},
                    true
                }
        });
    }

    @Test
    public void test() {
        FindRotation demo = new FindRotation();
        assertEquals(res, demo.findRotation(mat, target));
    }
}