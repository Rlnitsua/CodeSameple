package org.uncle.lee.binary.tree;

import java.util.List;

import org.uncle.lee.log.LogUtils;

public class BinaryTreeLevelOrderTraversal {
	private static final String TAG = "BinaryTreeLevelOrderTraversal";
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		return null;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new BinaryTreeLevelOrderTraversal().levelOrder(root));
	}
}
