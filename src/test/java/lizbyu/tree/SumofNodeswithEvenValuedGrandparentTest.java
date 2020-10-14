package lizbyu.tree;

import lizbyu.utils.node.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumofNodeswithEvenValuedGrandparentTest {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(8);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(3);
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        TreeNode treeNode7 = new TreeNode(9);
        treeNode3.left = treeNode7;
        TreeNode treeNode8 = new TreeNode(1);
        TreeNode treeNode9 = new TreeNode(4);
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        TreeNode treeNode10 = new TreeNode(5);
        treeNode6.right = treeNode10;

        SumofNodeswithEvenValuedGrandparent demo = new SumofNodeswithEvenValuedGrandparent();
        assertEquals(18, demo.sumEvenGrandparent(treeNode));
    }
}