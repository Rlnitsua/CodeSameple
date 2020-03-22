package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FourDivisorsTest {
    private int[] nums;
    private int sum;

    public FourDivisorsTest(int[] nums, int sum) {
        this.nums = nums;
        this.sum = sum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new int[]{21,4,7}, 32},
                {new int[]{7286,18704,70773,8224,91675}, 32}
        });
    }

    @Test
    public void sumFourDivisors() {
        FourDivisors demo = new FourDivisors();
        assertEquals(demo.sumFourDivisors(nums), sum);
    }
}