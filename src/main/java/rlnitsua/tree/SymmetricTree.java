package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        } else if (p1 == null || p2 == null) {
            return false;
        } else {
            return p1.val == p2.val &&
                    isSymmetric(p1.left, p2.right) &&
                    isSymmetric(p1.right, p2.left);
        }
    }
}
