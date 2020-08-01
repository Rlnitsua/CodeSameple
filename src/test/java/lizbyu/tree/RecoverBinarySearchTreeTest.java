package lizbyu.tree;

import lizbyu.utils.node.TreeNode;
import lizbyu.utils.node.TreeNodes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RecoverBinarySearchTreeTest {
    private TreeNode root;
    private TreeNode res;

    public RecoverBinarySearchTreeTest(TreeNode root, TreeNode res) {
        this.root = root;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TreeNodes.create(Arrays.asList(1,3,null,null,2)), TreeNodes.create(Arrays.asList(3,1,null,null,2))},
                {TreeNodes.create(Arrays.asList(3,1,4,null,null,2)), TreeNodes.create(Arrays.asList(2,1,4,null,null,3))},
        });
    }

    @Test
    public void test() {
        RecoverBinarySearchTree demo = new RecoverBinarySearchTree();
        demo.recoverTree(root);
        assertTrue(TreeNodes.isSameTree(root, res));
    }
}