package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UniquePathsTest {
    private final int m;
    private final int n;
    private final int res;

    public UniquePathsTest(int m, int n, int res) {
        this.m = m;
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 2, 3},
                {7, 3, 28},
        });
    }

    @Test
    public void test() {
        UniquePaths demo = new UniquePaths();
        assertEquals(res, demo.uniquePaths(m, n));
    }
}