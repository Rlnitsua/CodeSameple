package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberOfWeeksTest {
    private final int[] milestones;
    private final int res;

    public NumberOfWeeksTest(int[] milestones, int res) {
        this.milestones = milestones;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3}, 6},
                {new int[]{5,2,1}, 7},
        });
    }

    @Test
    public void test() {
        NumberOfWeeks demo = new NumberOfWeeks();
        assertEquals(res, demo.numberOfWeeks(milestones));
    }
}