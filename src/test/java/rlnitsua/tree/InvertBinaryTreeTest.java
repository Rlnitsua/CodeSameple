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
public class InvertBinaryTreeTest {
    private final TreeNode root;
    private final TreeNode res;

    public InvertBinaryTreeTest(TreeNode root, TreeNode res) {
        this.root = root;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(1, 2, 3)), TreeNodes.create(Arrays.asList(1, 3, 2))},
                {TreeNodes.create(Arrays.asList(1, 2, 3, null, null, 4, 5)), TreeNodes.create(Arrays.asList(1, 3, 2, 5, 4))},
        });
    }

    @Test
    public void test() {
        InvertBinaryTree demo = new InvertBinaryTree();
        assertTrue(TreeNodes.isSameTree(res, demo.invertTree(root)));
    }
}