package lizbyu.binary.tree;

import lizbyu.utils.node.TreeNode;

public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return calculateTilt(root) + findTilt(root.left) + findTilt(root.right);
    }

    private int calculateTilt(TreeNode root) {
        return Math.abs(calculateSum(root.left) - calculateSum(root.right));
    }

    private int calculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val;
        sum += calculateSum(root.left);
        sum += calculateSum(root.right);
        return sum;
    }
}
