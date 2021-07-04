package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountGoodNumbersTest {
    private final long n;
    private final int res;

    public CountGoodNumbersTest(long n, int res) {
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {17,999999111},
                {50,564908303},
                {1,5},
                {4,400},
        });
    }

    @Test
    public void test() {
        CountGoodNumbers demo = new CountGoodNumbers();
        assertEquals(res, demo.countGoodNumbers(n));
    }
}