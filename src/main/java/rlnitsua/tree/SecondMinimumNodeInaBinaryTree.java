package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        } else {
            int bigger = Math.max(root.left.val, root.right.val);
            int second = dfs(root, root.val, bigger);
            return second == root.val ? -1 : second;
        }
    }

    private int dfs(TreeNode root, int min, int second) {
        if (root == null) {
            return second;
        }
        if (root.val == min) {
            if (root.left == null) {
                return second;
            } else {
                if (root.left.val != min) {
                    second = Math.min(second, root.left.val);
                    return dfs(root.right, min, second);
                } else if (root.right.val != min) {
                    second = Math.min(second, root.right.val);
                    return dfs(root.left, min, second);
                } else {
                    return Math.min(dfs(root.left, min, second), dfs(root.right, min, second));
                }
            }
        } else {
            return second;
        }
    }
}
