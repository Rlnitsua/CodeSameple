package rlnitsua.bit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class XOROperationinanArrayTest {
    private int n;
    private int start;
    private int res;

    public XOROperationinanArrayTest(int n, int start, int res) {
        this.n = n;
        this.start = start;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 0, 8},
                {4, 3, 8},
                {1, 7, 7},
                {10, 5, 2},
        });
    }

    @Test
    public void test() {
        XOROperationinanArray demo = new XOROperationinanArray();
        assertEquals(res, demo.xorOperation(n, start));
    }
}