package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PokerIsContinuousTest {
    private final int[] numbers;
    private final boolean res;

    public PokerIsContinuousTest(int[] numbers, boolean res) {
        this.numbers = numbers;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0,3,2,6,4}, true},
                {new int[]{0,0,0,1,2}, true},
                {new int[]{0,3,1,2,6}, false},
                {new int[]{11,8,12,8,10}, false},
        });
    }

    @Test
    public void test() {
        PokerIsContinuous demo = new PokerIsContinuous();
        assertEquals(res, demo.isContinuous(numbers));
    }
}