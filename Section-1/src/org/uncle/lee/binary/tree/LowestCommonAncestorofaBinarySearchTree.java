package org.uncle.lee.binary.tree;

import org.uncle.lee.log.LogUtils;
import org.uncle.lee.util.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {
	private static final String TAG = "LowestCommonAncestorofaBinarySearchTree";
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while((root.val - p.val) * (root.val - q.val) > 0){
			root = root.val > p.val ? root.left : root.right;
		}
		return root;
	}
	
	
	public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		
		if(root == p){
			if(inBranch(q, root.left) || inBranch(q, root.right)){
				return root;
			} else {
				return null;
			}
		}else if (root == q){
			if(inBranch(p, root.left) || inBranch(p, root.right)){
				return root;
			}else {
				return null;
			}
		}else if(inBranch(p, root.left) && inBranch(q, root.right)
				|| inBranch(p, root.right) && inBranch(q, root.left)){
			return root;
		}else {
			TreeNode leftReuslt = lowestCommonAncestor(root.left, p, q);
			if(leftReuslt != null){
				return leftReuslt;
			}else {
				return lowestCommonAncestor(root.right, p, q);
			}
		}
	}

	private boolean inBranch(TreeNode q, TreeNode tree) {
		if(tree == null){
			return false;
		}
		
		if(tree.val == q.val && tree.left == q.left && tree.right == q.right){
			return true;
		}else {
			return inBranch(q, tree.left) || inBranch(q, tree.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(3);
		TreeNode node9 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new LowestCommonAncestorofaBinarySearchTree().lowestCommonAncestor(node1, node2, node3).val);
		LogUtils.d(TAG, new LowestCommonAncestorofaBinarySearchTree().lowestCommonAncestor(node1, node2, node5).val);
		LogUtils.d(TAG, new LowestCommonAncestorofaBinarySearchTree().lowestCommonAncestor(node1, node8, node9).val);
	}
}
