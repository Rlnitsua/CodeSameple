package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LongestHappyStringTest {
    private int a;
    private int b;
    private int c;
    private String res;

    public LongestHappyStringTest(int a, int b, int c, String res) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {1, 1, 7, "ccaccbcc"},
                {2, 2, 1, "aabbc"},
                {7, 1, 0, "aabaa"},
                {4, 4, 3, "aabbccaabbc"}
        });
    }

    @Test
    public void longestDiverseString() {
        LongestHappyString demo = new LongestHappyString();
        assertEquals(demo.longestDiverseString(a, b, c), res);
    }
}