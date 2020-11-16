package rlnitsua.tree;

import rlnitsua.utils.node.TreeNode;

public class KthSmallestElementinaBST {
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null || count == 0) {
            return;
        }
        dfs(root.left);
        if (--count == 0) {
            res = root.val;
            return;
        }
        dfs(root.right);
    }
}
