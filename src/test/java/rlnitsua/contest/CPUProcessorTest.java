package rlnitsua.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CPUProcessorTest {
    private final int[][] tasks;
    private final int[] res;

    public CPUProcessorTest(int[][] tasks, int[] res) {
        this.tasks = tasks;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1,2}, new int[]{2,4}, new int[]{3,2}, new int[]{4,1}}, new int[]{0,2,3,1}},
                {new int[][]{new int[]{7,10}, new int[]{7,12}, new int[]{7,5}, new int[]{7,4}, new int[]{7,2}},
                        new int[]{4,3,2,0,1}},
        });
    }

    @Test
    public void test() {
        CPUProcessor demo = new CPUProcessor();
        assertArrayEquals(res, demo.getOrder(tasks));
    }
}