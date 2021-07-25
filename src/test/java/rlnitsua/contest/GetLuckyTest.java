package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GetLuckyTest {
    private final String s;
    private final int k;
    private final int res;

    public GetLuckyTest(String s, int k, int res) {
        this.s = s;
        this.k = k;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"iiii", 1, 36},
                {"leetcode", 2, 6},
        });
    }

    @Test
    public void test() {
        GetLucky demo = new GetLucky();
        assertEquals(res, demo.getLucky(s, k));
    }
}