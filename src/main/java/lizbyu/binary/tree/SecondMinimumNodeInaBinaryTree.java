package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class SecondMinimumNodeInaBinaryTree {
    private static final String TAG = "SecondMinimumNodeInaBinaryTree";
    private int min = Integer.MAX_VALUE;
    private int second = Integer.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        calculateSecond(root);
        return second == Integer.MAX_VALUE ? -1 : second;
    }

    private void calculateSecond(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val < min) {
            second = min;
            min = root.val;
        } else if (root.val > min) {
            if (root.val < second) {
                second = root.val;
            }
        }

        calculateSecond(root.left);
        calculateSecond(root.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        TreeNode head1 = new TreeNode(2);
        TreeNode head2 = new TreeNode(5);
        TreeNode head3 = new TreeNode(5);
        TreeNode head4 = new TreeNode(7);
        head.left = head1;
        head.right = head2;
        head2.left = head3;
        head2.right = head4;

        LogUtils.d(TAG, new SecondMinimumNodeInaBinaryTree().findSecondMinimumValue(head));
    }
}
