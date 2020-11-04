package rlnitsua.tree;

import rlnitsua.utils.log.LogUtils;

public class SumofLeftLeaves {
    private static final String TAG = "SumofLeftLeaves";

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null
                && root.left.left == null
                && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new SumofLeftLeaves().new TreeNode(3);
        TreeNode rootLeft = new SumofLeftLeaves().new TreeNode(9);
        TreeNode rootRight = new SumofLeftLeaves().new TreeNode(20);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode left3 = new SumofLeftLeaves().new TreeNode(15);
        TreeNode right3 = new SumofLeftLeaves().new TreeNode(7);
        rootRight.left = left3;
        rootRight.right = right3;

        LogUtils.d(TAG, new SumofLeftLeaves().sumOfLeftLeaves(root));
    }
}
