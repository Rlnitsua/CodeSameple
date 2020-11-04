package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DietPlanPerformanceTest {
    private final int[] calories;
    private final int k;
    private final int lower;
    private final int upper;
    private final int res;

    public DietPlanPerformanceTest(int[] calories, int k, int lower, int upper, int res) {
        this.calories = calories;
        this.k = k;
        this.lower = lower;
        this.upper = upper;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 1, 3, 3, 0},
                {new int[]{3, 2}, 2, 0, 1, 1},
                {new int[]{6, 5, 0, 0}, 2, 1, 5, 0},
        });
    }

    @Test
    public void test() {
        DietPlanPerformance demo = new DietPlanPerformance();
        assertEquals(res, demo.dietPlanPerformance(calories, k, lower, upper));
    }
}