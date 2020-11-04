package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

public class SumofNodeswithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    res += root.left.left.val;
                }
                if (root.left.right != null) {
                    res += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    res += root.right.left.val;
                }
                if (root.right.right != null) {
                    res += root.right.right.val;
                }
            }
        }
        return res + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
