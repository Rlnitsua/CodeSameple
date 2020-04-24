package lizbyu.bit.manipulation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberofStepstoReduceaNumbertoZeroTest {
    private int num;
    private int step;

    public NumberofStepstoReduceaNumbertoZeroTest(int num, int step) {
        this.num = num;
        this.step = step;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {14, 6},
                {8, 4},
                {123, 12}
        });
    }

    @Test
    public void numberOfSteps() {
        NumberofStepstoReduceaNumbertoZero demo = new NumberofStepstoReduceaNumbertoZero();
        assertEquals(step, demo.numberOfSteps(num));
    }
}