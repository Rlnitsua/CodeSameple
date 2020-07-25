package lizbyu.tree;

import lizbyu.utils.node.TreeNode;

public class BinarySearchTreetoGreaterSumTree {
    private int base = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = bstToGst(root.right);
        base += root.val;
        root.val = base;
        root.left = bstToGst(root.left);
        return root;
    }
}
