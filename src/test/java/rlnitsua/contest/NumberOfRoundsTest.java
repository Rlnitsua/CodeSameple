package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberOfRoundsTest {
    private final String startTime;
    private final String finishTime;
    private final int res;

    public NumberOfRoundsTest(String startTime, String finishTime, int res) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"12:01", "12:44", 1},
                {"00:00", "00:59", 3},
                {"20:00", "06:00", 40},
                {"00:00", "23:59", 95},
        });
    }

    @Test
    public void test() {
        NumberOfRounds demo = new NumberOfRounds();
        assertEquals(res, demo.numberOfRounds(startTime, finishTime));
    }
}