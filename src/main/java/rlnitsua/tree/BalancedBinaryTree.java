package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = new boolean[]{true};
        getHeight(root, 1, isBalanced);
        return isBalanced[0];
    }

    private int getHeight(TreeNode root, int level, boolean[] isBalanced) {
        if (root == null) {
            return level;
        }

        int lH = getHeight(root.left, level + 1, isBalanced);
        if (!isBalanced[0]) {
            return lH;
        }

        int rH = getHeight(root.right, level + 1, isBalanced);
        if (!isBalanced[0]) {
            return rH;
        }

        if (Math.abs(lH - rH) > 1) {
            isBalanced[0] = false;
        }

        return Math.max(lH, rH);
    }
}
