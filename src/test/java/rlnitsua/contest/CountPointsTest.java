package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountPointsTest {
    private final int[][] points;
    private final int[][] queries;
    private final int[] res;

    public CountPointsTest(int[][] points, int[][] queries, int[] res) {
        this.points = points;
        this.queries = queries;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1,3},new int[]{3,3},new int[]{5,3},new int[]{2,2}},
                        new int[][]{new int[]{2,3,1},new int[]{4,3,1},new int[]{1,1,2}}, new int[]{3,2,2}},
                {new int[][]{new int[]{1,1},new int[]{2,2},new int[]{3,3},new int[]{4,4},new int[]{5,5}},
                        new int[][]{new int[]{1,2,2},new int[]{2,2,2},new int[]{4,3,2},new int[]{4,3,3}}, new int[]{2,3,2,4}},
        });
    }

    @Test
    public void test() {
        CountPoints demo = new CountPoints();
        assertArrayEquals(res, demo.countPoints(points, queries));
    }

    @Test
    public void name() {
        System.out.println(~9);
    }
}