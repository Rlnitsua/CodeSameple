package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinimumPerimeterTest {
    private final long neededApples;
    private final long res;

    public MinimumPerimeterTest(long neededApples, long res) {
        this.neededApples = neededApples;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1000000000, 5040},
                {1, 8},
                {13, 16},
        });
    }

    @Test
    public void test() {
        MinimumPerimeter demo = new MinimumPerimeter();
        assertEquals(res, demo.minimumPerimeter(neededApples));
    }
}