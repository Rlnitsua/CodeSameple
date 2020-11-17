package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
