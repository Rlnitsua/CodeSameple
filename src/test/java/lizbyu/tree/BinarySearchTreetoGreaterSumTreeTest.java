package lizbyu.tree;

import lizbyu.utils.node.TreeNode;
import lizbyu.utils.node.TreeNodes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BinarySearchTreetoGreaterSumTreeTest {
    private TreeNode root;
    private TreeNode res;

    public BinarySearchTreetoGreaterSumTreeTest(TreeNode root, TreeNode res) {
        this.root = root;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)),
                        TreeNodes.create(Arrays.asList(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8))},
        });
    }

    @Test
    public void test() {
        BinarySearchTreetoGreaterSumTree demo = new BinarySearchTreetoGreaterSumTree();
        assertTrue(TreeNodes.isSameTree(res, demo.bstToGst(root)));
    }
}