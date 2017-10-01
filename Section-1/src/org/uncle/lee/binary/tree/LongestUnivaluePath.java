package org.uncle.lee.binary.tree;

import org.uncle.lee.log.LogUtils;
import org.uncle.lee.util.TreeNode;

public class LongestUnivaluePath {
	private static final String TAG = "LongestUnivaluePath";
	
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		if ((root.left != null) && (root.right != null)) {
			if ((root.val == root.left.val) && (root.val == root.right.val)) {
				return longestUnivaluePath(root.left) + longestUnivaluePath(root.right) + 2;
			}
			
			else if ((root.val == root.left.val) && (root.val != root.right.val)) {
				return Math.max(longestUnivaluePath(root.left) + 1, longestUnivaluePath(root.right));
			}
			
			else if ((root.val != root.left.val) && (root.val == root.right.val)) {
				return Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right) + 1);
			}
			
			else {
				return Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
			}
		} 
		
		else if ((root.left == null) && (root.right != null)) {
			if (root.val == root.right.val) {
				return longestUnivaluePath(root.right) + 1;
			} else {
				return longestUnivaluePath(root.right);
			}
		}
		
		else if ((root.left != null) && (root.right == null)) {
			if (root.val == root.left.val) {
				return longestUnivaluePath(root.left) + 1;
			} else {
				return longestUnivaluePath(root.left);
			}
		}
		
		else {
			return 0;
		}
	}
	
	public static void main (String[] args) {
		TreeNode head0 = getHead0();
		TreeNode head1 = getHead1();
		LongestUnivaluePath demo = new LongestUnivaluePath();
		LogUtils.d(TAG, demo.longestUnivaluePath(head0));
		LogUtils.d(TAG, demo.longestUnivaluePath(head1));
	}

	private static TreeNode getHead0() {
		TreeNode head = new TreeNode(5);
		TreeNode head1 = new TreeNode(4);
		TreeNode head2 = new TreeNode(5);
		TreeNode head3 = new TreeNode(1);
		TreeNode head4 = new TreeNode(1);
		TreeNode head5 = new TreeNode(5);
		head.left = head1;
		head.right = head2;
		head1.left = head3;
		head1.right = head4;
		head2.right = head5;
		return head;
	}
	

	private static TreeNode getHead1() {
		TreeNode head0 = new TreeNode(1);
		TreeNode head = new TreeNode(1);
		TreeNode head1 = new TreeNode(4);
		TreeNode head2 = new TreeNode(5);
		TreeNode head3 = new TreeNode(4);
		TreeNode head4 = new TreeNode(4);
		TreeNode head5 = new TreeNode(5);
		
		head0.left = head;
		head.left = head1;
		head.right = head2;
		head1.left = head3;
		head1.right = head4;
		head2.right = head5;
		return head0;
	}
}
