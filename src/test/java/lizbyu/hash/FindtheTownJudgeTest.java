package lizbyu.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindtheTownJudgeTest {
    private final int n;
    private final int[][] trust;
    private final int res;

    public FindtheTownJudgeTest(int n, int[][] trust, int res) {
        this.n = n;
        this.trust = trust;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, new int[][]{new int[]{1,2}}, 2},
                {1, new int[][]{}, 1},
                {3, new int[][]{new int[]{1,3}, new int[]{2,3}}, 3},
                {3, new int[][]{new int[]{1,3}, new int[]{2,3}, new int[]{3,1}}, -1},
                {3, new int[][]{new int[]{1,2}, new int[]{2,3}}, -1},
                {4, new int[][]{new int[]{1,3}, new int[]{1,4}, new int[]{2,3}, new int[]{2,4}, new int[]{4,3}}, 3},
        });
    }

    @Test
    public void test() {
        FindtheTownJudge demo = new FindtheTownJudge();
        assertEquals(res, demo.findJudge(n, trust));
    }
}