package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TraversalArrayTest {
    private final int[][] matrix;
    private final int[] res;

    public TraversalArrayTest(int[][] matrix, int[] res) {
        this.matrix = matrix;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}},
                        new int[]{1,2,3,6,9,8,7,4,5}},
                {new int[][]{new int[]{1,2,3,4}, new int[]{5,6,7,8}, new int[]{9,10,11,12}, new int[]{13,14,15,16}},
                        new int[]{1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10}}
        });
    }

    @Test
    public void test() {
        TraversalArray demo = new TraversalArray();
        assertArrayEquals(res, demo.printMatrix(matrix));
    }
}