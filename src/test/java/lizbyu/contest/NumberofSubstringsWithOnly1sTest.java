package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberofSubstringsWithOnly1sTest {
    private String s;
    private int res;

    public NumberofSubstringsWithOnly1sTest(String s, int res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {"0110111", 9},
                {"101", 2},
                {"111111", 21},
                {"000", 0},
        });
    }

    @Test
    public void test() {
        NumberofSubstringsWithOnly1s demo = new NumberofSubstringsWithOnly1s();
        assertEquals(res, demo.numSub(s));
    }
}