package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MinimumOperationstoMakeArrayEqualTest {
    private int n;
    private int res;

    public MinimumOperationstoMakeArrayEqualTest(int n, int res) {
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 2},
                {6, 9}
        });
    }

    @Test
    public void test() {
        MinimumOperationstoMakeArrayEqual demo = new MinimumOperationstoMakeArrayEqual();
        assertEquals(res, demo.minOperations(n));
    }
}