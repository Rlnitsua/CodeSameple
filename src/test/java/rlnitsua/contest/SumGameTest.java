package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SumGameTest {
    private final String num;
    private final boolean res;

    public SumGameTest(String num, boolean res) {
        this.num = num;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"5023", false},
                {"25??", true},
                {"?3295???", false},
                {"??????", false},
        });
    }

    @Test
    public void test() {
        SumGame demo = new SumGame();
        assertEquals(res, demo.sumGame(num));
    }
}