package org.uncle.lee.binary.tree;

import org.uncle.lee.log.LogUtils;

public class PathSumIII {
	private static final String TAG = "PathSumIII";
	
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int pathSum(TreeNode root, int sum) {
		if(root == null){
			return 0;
		}
		return findPath(root, sum) + pathSum(root.left, sum) 
				+ pathSum(root.right, sum);
	}
	
	private int findPath(TreeNode root, int sum){
		int count = 0;
		if(root == null){
			return count;
		}
		if(root.val == sum){
			count ++;
		}
		
		count += findPath(root.left, sum - root.val);
		count += findPath(root.right, sum - root.val);
		
		return count;
	}
	
	public static void main(String[] args) {
		TreeNode head = initTreeNode();
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new PathSumIII().pathSum(head, 8));
	}

	private static TreeNode initTreeNode() {
		TreeNode node1 = new PathSumIII().new TreeNode(10);
		TreeNode node2 = new PathSumIII().new TreeNode(5);
		TreeNode node3 = new PathSumIII().new TreeNode(-3);
		TreeNode node4 = new PathSumIII().new TreeNode(3);
		TreeNode node5 = new PathSumIII().new TreeNode(2);
		TreeNode node6 = new PathSumIII().new TreeNode(11);
		TreeNode node7 = new PathSumIII().new TreeNode(3);
		TreeNode node8 = new PathSumIII().new TreeNode(-2);
		TreeNode node9 = new PathSumIII().new TreeNode(1);
		TreeNode node10 = new PathSumIII().new TreeNode(5);
		
		node1.left = node2;
		node1.right = node2;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node5.right = node9;
		node7.left = node10;
		
		return node1;
	}
}
