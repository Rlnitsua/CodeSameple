package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;

public class MaximumDepthofBinaryTree {
	private static final String TAG = "MaximumDepthofBinaryTree";
	
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new MaximumDepthofBinaryTree().new TreeNode(1);
		TreeNode node2 = new MaximumDepthofBinaryTree().new TreeNode(1);
		TreeNode node3 = new MaximumDepthofBinaryTree().new TreeNode(1);
		TreeNode node4 = new MaximumDepthofBinaryTree().new TreeNode(1);
		TreeNode node5 = new MaximumDepthofBinaryTree().new TreeNode(1);
		TreeNode node6 = new MaximumDepthofBinaryTree().new TreeNode(1);
		TreeNode node7 = new MaximumDepthofBinaryTree().new TreeNode(1);
		TreeNode node8 = new MaximumDepthofBinaryTree().new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.right = node6;
		
		node4.left = node7;
		node7.left = node8;
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new MaximumDepthofBinaryTree().maxDepth(node1));
		
	}
	
}
