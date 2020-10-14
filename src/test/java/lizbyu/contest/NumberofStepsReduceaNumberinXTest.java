package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberofStepsReduceaNumberinXTest {
    private String s;
    private int res;

    public NumberofStepsReduceaNumberinXTest(String s, int res) {
        this.s = s;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {"1101", 6},
                {"10", 1},
                {"1", 0},
        });
    }

    @Test
    public void numSteps() {
        NumberofStepsReduceaNumberinX demo = new NumberofStepsReduceaNumberinX();
        assertEquals(res, demo.numSteps(s));
    }
}