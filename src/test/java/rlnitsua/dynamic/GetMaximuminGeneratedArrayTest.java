package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GetMaximuminGeneratedArrayTest {
    private final int n;
    private final int res;

    public GetMaximuminGeneratedArrayTest(int n, int res) {
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {7, 3},
                {2, 1},
                {3, 2},
                {4, 2},
        });
    }

    @Test
    public void test() {
        GetMaximuminGeneratedArray demo = new GetMaximuminGeneratedArray();
        assertEquals(res, demo.getMaximumGenerated(n));
    }
}