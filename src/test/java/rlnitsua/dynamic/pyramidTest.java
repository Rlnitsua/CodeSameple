package rlnitsua.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class pyramidTest {
    private int n;
    private List<Integer> k;
    private int res;

    public pyramidTest(int n, List<Integer> k, int res) {
        this.n = n;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, Arrays.asList(1, 2, 3), 9},
        });
    }

    @Test
    public void test() {
        pyramid demo = new pyramid();
        assertEquals(res, demo.pyramid(n, k));
    }
}