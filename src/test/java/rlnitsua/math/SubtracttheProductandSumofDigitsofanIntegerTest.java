package rlnitsua.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SubtracttheProductandSumofDigitsofanIntegerTest {
    private int n;
    private int res;

    public SubtracttheProductandSumofDigitsofanIntegerTest(int n, int res) {
        this.n = n;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {234, 15},
                {4421, 21},
        });
    }

    @Test
    public void test() {
        SubtracttheProductandSumofDigitsofanInteger demo = new SubtracttheProductandSumofDigitsofanInteger();
        assertEquals(res, demo.subtractProductAndSum(n));
    }
}