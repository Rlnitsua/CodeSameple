package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BulbSwitcherIVTest {
    private String target;
    private int res;

    public BulbSwitcherIVTest(String target, int res) {
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"10111", 3},
                {"101", 3},
                {"0000", 0},
                {"001011101", 5},
        });
    }

    @Test
    public void test() {
        BulbSwitcherIV demo = new BulbSwitcherIV();
        assertEquals(res, demo.minFlips(target));
    }
}