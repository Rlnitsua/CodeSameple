package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DefusetheBombTest {
    private final int[] code;
    private final int k;
    private final int[] res;

    public DefusetheBombTest(int[] code, int k, int[] res) {
        this.code = code;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5,7,1,4}, 3, new int[]{12,10,16,13}},
                {new int[]{1,2,3,4}, 0, new int[]{0,0,0,0}},
                {new int[]{2,4,9,3}, -2, new int[]{12,5,6,13}},
        });
    }

    @Test
    public void test() {
        DefusetheBomb demo = new DefusetheBomb();
        assertArrayEquals(res, demo.decrypt(code, k));
    }
}