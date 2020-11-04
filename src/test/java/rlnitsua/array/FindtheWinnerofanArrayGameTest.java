package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FindtheWinnerofanArrayGameTest {
    private int[] arr;
    private int k;
    private int res;

    public FindtheWinnerofanArrayGameTest(int[] arr, int k, int res) {
        this.arr = arr;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 1, 3, 5, 4, 6, 7}, 2, 5},
                {new int[]{3, 2, 1}, 10, 3},
                {new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7, 9},
                {new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000, 99},
        });
    }

    @Test
    public void test() {
        FindtheWinnerofanArrayGame demo = new FindtheWinnerofanArrayGame();
        assertEquals(res, demo.getWinner(arr, k));
    }
}