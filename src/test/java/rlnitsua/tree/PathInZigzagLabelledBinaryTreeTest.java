package rlnitsua.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PathInZigzagLabelledBinaryTreeTest {
    private final int label;
    private final List<Integer> res;

    public PathInZigzagLabelledBinaryTreeTest(int label, List<Integer> res) {
        this.label = label;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {14, Arrays.asList(1, 3, 4, 14)},
                {26, Arrays.asList(1, 2, 6, 10, 26)},
        });
    }

    @Test
    public void test() {
        PathInZigzagLabelledBinaryTree demo = new PathInZigzagLabelledBinaryTree();
        assertEquals(res, demo.pathInZigZagTree(label));
    }
}