package rlnitsua.divide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MajorityElementTest {
    private final int[] nums;
    private final int res;

    public MajorityElementTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3,2,3}, 3},
                {new int[]{2,2,1,1,1,2,2}, 2}
        });
    }

    @Test
    public void test() {
        MajorityElement demo = new MajorityElement();
        assertEquals(res, demo.majorityElement(nums));
    }
}