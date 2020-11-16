package rlnitsua.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rlnitsua.utils.node.TreeNode;
import rlnitsua.utils.node.TreeNodes;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MaximumDepthofBinaryTreeTest {
    private final TreeNode root;
    private final int res;

    public MaximumDepthofBinaryTreeTest(TreeNode root, int res) {
        this.root = root;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(3, 9, 20, null, null, 15, 7)), 3},
        });
    }

    @Test
    public void test() {
        MaximumDepthofBinaryTree demo = new MaximumDepthofBinaryTree();
        assertEquals(res, demo.maxDepth(root));
    }
}