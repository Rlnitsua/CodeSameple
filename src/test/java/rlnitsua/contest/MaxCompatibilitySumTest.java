package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaxCompatibilitySumTest {
    private final int[][] students;
    private final int[][] mentors;
    private final int res;

    public MaxCompatibilitySumTest(int[][] students, int[][] mentors, int res) {
        this.students = students;
        this.mentors = mentors;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1,1,0}, new int[]{1,0,1}, new int[]{0,0,1}},
                        new int[][]{new int[]{1,0,0}, new int[]{0,0,1}, new int[]{1,1,0}}, 8},
                {new int[][]{new int[]{0,0}, new int[]{0,0}, new int[]{0,0}},
                        new int[][]{new int[]{1,1}, new int[]{1,1}, new int[]{1,1}}, 0},
        });
    }

    @Test
    public void test() {
        MaxCompatibilitySum demo = new MaxCompatibilitySum();
        assertEquals(res, demo.maxCompatibilitySum(students, mentors));
    }
}