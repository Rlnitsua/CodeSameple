package lizbyu.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumbersAtMostNGivenDigitSetTest {
    private String[] D;
    private int N;
    private int res;

    public NumbersAtMostNGivenDigitSetTest(String[] d, int n, int res) {
        D = d;
        N = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"1", "3", "5", "7"}, 100, 20},
                {new String[]{"1", "4", "9"}, 1000000000, 29523},
        });
    }

    @Test
    public void test() {
        NumbersAtMostNGivenDigitSet demo = new NumbersAtMostNGivenDigitSet();
        assertEquals(res, demo.atMostNGivenDigitSet(D, N));
    }

}