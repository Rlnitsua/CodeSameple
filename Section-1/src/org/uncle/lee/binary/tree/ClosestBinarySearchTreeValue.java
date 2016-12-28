package org.uncle.lee.binary.tree;

import org.uncle.lee.log.LogUtils;

public class ClosestBinarySearchTreeValue {
	private static final String TAG = "ClosestBinarySearchTreeValue";

	public int closestValue(TreeNode root, double target) {
		if (root.left != null && target <= (root.val + root.left.val) / 2) {
			return closestValue(root.left, target);
		} else if (root.right != null
				&& target >= (root.val + root.right.val) / 2) {
			return closestValue(root.right, target);
		} else {
			return root.val;
		}
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(1);
		node1.left = node2;

		LogUtils.d(TAG, "start");
		LogUtils.d(TAG,
				new ClosestBinarySearchTreeValue().closestValue(node1, 6));
	}
}
