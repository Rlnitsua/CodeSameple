package rlnitsua.tree;

import rlnitsua.utils.log.LogUtils;
import rlnitsua.utils.node.TreeNode;

public class MinimumDepthofBinaryTree {
    private static final String TAG = "MinimumDepthofBinaryTree";
    private int min = 0;

    public int minDepth(TreeNode root) {
        traverseTree(root, 0);
        return min;
    }

    private void traverseTree(TreeNode root, int deep) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            deep++;
            if (min == 0) {
                min = deep;
            } else {
                min = Math.min(min, deep);
            }
            return;
        }

        deep++;
        if (min != 0 && deep > min) {
            return;
        }
        traverseTree(root.left, deep);
        traverseTree(root.right, deep);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.left = node6;
        node6.left = node7;

        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new MinimumDepthofBinaryTree().minDepth(node1));
    }
}
