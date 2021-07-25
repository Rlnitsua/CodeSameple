package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumNumberTest {
    private final String num;
    private final int[] change;
    private final String res;

    public MaximumNumberTest(String num, int[] change, String res) {
        this.num = num;
        this.change = change;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"334111", new int[]{0,9,2,3,3,2,5,5,5,5}, "334999"},
                {"132", new int[]{9,8,5,0,3,6,4,2,6,8}, "832"},
                {"021", new int[]{9,4,3,5,7,2,1,9,0,6}, "934"},
                {"5", new int[]{1,4,7,5,3,2,5,6,9,4}, "5"},
        });
    }

    @Test
    public void test() {
        MaximumNumber demo = new MaximumNumber();
        assertEquals(res, demo.maximumNumber(num, change));
    }
}