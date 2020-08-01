package lizbyu.tree;

import lizbyu.utils.node.TreeNode;

public class RecoverBinarySearchTree {
    private int pre = 0;
    private boolean isFirstTraver = true;
    private boolean isFirstPair = true;
    private int a;
    private int b;

    public void recoverTree(TreeNode root) {
        dfs(root);
        swapVal(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (isFirstTraver) {
            pre = root.val;
            isFirstTraver = false;
        } else {
            if (root.val < pre) {
                if (isFirstPair) {
                    a = pre;
                    b = root.val;
                    isFirstPair = false;
                } else {
                    b = root.val;
                }
            }
            pre = root.val;
        }

        dfs(root.right);
    }

    private void swapVal(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val == a) {
            root.val = b;
        } else if (root.val == b) {
            root.val = a;
        }
        swapVal(root.left);
        swapVal(root.right);
    }
}
