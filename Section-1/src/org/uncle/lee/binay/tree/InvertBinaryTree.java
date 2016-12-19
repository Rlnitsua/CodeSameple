package org.uncle.lee.binay.tree;

public class InvertBinaryTree {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if(root != null){
			if (root.left == null && root.right == null) {
				return root;
			} else {
				TreeNode oldLeft = root.left;
				root.left = root.right;
				root.right = oldLeft;
				
				invertTree(root.left);
				invertTree(root.right);
			}
		}
		return root;
	}
}
