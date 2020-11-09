package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TwoSumTest {
    private final int[] numbers;
    private final int target;
    private final int[] res;

    public TwoSumTest(int[] numbers, int target, int[] res) {
        this.numbers = numbers;
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 2, 4}, 6, new int[]{1, 2}},
        });
    }

    @Test
    public void test() {
        TwoSum demo = new TwoSum();
        assertArrayEquals(res, demo.twoSum(numbers, target));
    }
}