package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LastMomentBeforeAllAntsFallOutofaPlankTest {
    private int n;
    private int[] left;
    private int[] right;
    private int time;

    public LastMomentBeforeAllAntsFallOutofaPlankTest(int n, int[] left, int[] right, int time) {
        this.n = n;
        this.left = left;
        this.right = right;
        this.time = time;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {4, new int[]{4, 3}, new int[]{0, 1}, 4},
                {7, new int[]{}, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 7},
                {7, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{}, 7},
                {9, new int[]{5}, new int[]{4}, 5},
                {6, new int[]{6}, new int[]{0}, 6},
        });
    }

    @Test
    public void test() {
        LastMomentBeforeAllAntsFallOutofaPlank demo = new LastMomentBeforeAllAntsFallOutofaPlank();
        assertEquals(time, demo.getLastMoment(n, left, right));
    }
}