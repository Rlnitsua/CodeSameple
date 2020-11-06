package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinarySearchTest {
    private final int v;
    private final int[] a;
    private final int res;

    public BinarySearchTest(int v, int[] a, int res) {
        this.v = v;
        this.a = a;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, new int[]{1,2,4,4,5}, 3},
                {1, new int[]{1,2,4,4,5}, 1},
                {4, new int[]{1,2,3}, 4},
                {100, new int[]{2,3,3,4,4,5,5,5,6,6,7,7,9,9,9,10,10,12,14,16,17,18,18,
                        18,19,22,23,23,26,26,26,26,28,28,29,29,29,32,33,35,36,38,39,39,
                        40,41,46,47,47,47,49,50,54,55,55,55,56,57,57,58,58,58,59,61,61,
                        62,62,62,62,63,63,67,67,69,70,70,71,72,74,75,76,79,84,85,85,86,
                        89,92,93,93,93,94,94,95,97,97,97,97,97,99}, 101},
        });
    }

    @Test
    public void test() {
        BinarySearch demo = new BinarySearch();
        assertEquals(res, demo.search(v, a));
    }
}