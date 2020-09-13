package lizbyu.tree;

import lizbyu.utils.node.TreeNode;

public class BinaryTreeTilt {
    private int sum;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
}
