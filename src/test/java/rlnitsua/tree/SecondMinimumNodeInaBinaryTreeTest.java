package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;
import rlnitsua.utils.node.TreeNodes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SecondMinimumNodeInaBinaryTreeTest {
    private final TreeNode root;
    private final int res;

    public SecondMinimumNodeInaBinaryTreeTest(TreeNode root, int res) {
        this.root = root;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(2, 2, 5, null, null, 5, 7)), 5},
                {TreeNodes.create(Arrays.asList(2, 2, 2)), -1},
                {TreeNodes.create(Collections.singletonList(2)), -1},
                {TreeNodes.create(Arrays.asList(1,1,2,1,1,2,2)), 2}
        });
    }

    @Test
    public void test() {
        SecondMinimumNodeInaBinaryTree demo = new SecondMinimumNodeInaBinaryTree();
        assertEquals(res, demo.findSecondMinimumValue(root));
    }
}