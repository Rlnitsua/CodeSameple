package lizbyu.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PlanningTreeTest {
    private final int[] trees;
    private final int d;
    private final int res;

    public PlanningTreeTest(int[] trees, int d, int res) {
        this.trees = trees;
        this.d = d;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 5, 6}, 2, 2},
        });
    }

    @Test
    public void test() {
        PlanningTree demo = new PlanningTree();
        assertEquals(res, demo.treePlanning(trees, d));
    }
}