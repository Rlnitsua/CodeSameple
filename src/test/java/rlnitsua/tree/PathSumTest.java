package rlnitsua.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rlnitsua.utils.node.TreeNode;
import rlnitsua.utils.node.TreeNodes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PathSumTest {
    private final TreeNode root;
    private final int sum;
    private final boolean res;

    public PathSumTest(TreeNode root, int sum, boolean res) {
        this.root = root;
        this.sum = sum;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 22, true},
        });
    }

    @Test
    public void test() {
        PathSum demo = new PathSum();
        assertEquals(res, demo.hasPathSum(root, sum));
    }
}