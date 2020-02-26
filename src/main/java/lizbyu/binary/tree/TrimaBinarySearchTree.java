package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class TrimaBinarySearchTree {
	private static final String TAG = "TrimaBinarySearchTree";
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
		doTrim(root, L, R);
		return root;
	}
	
	private void doTrim(TreeNode root, int L, int R) {
		if (root == null) {
			return;
		}
		
		if (root.val < L) {
			root = root.right;
			doTrim(root, L, R);
		} else if (root.val > R) {
			root = root.left;
			doTrim(root, L, R);
		} 
		
		if (root != null) {
			doTrim(root.left, L, R);
			doTrim(root.right, L, R);
		}
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(3);
		TreeNode head1 = new TreeNode(0);
		TreeNode head2 = new TreeNode(4);
		TreeNode head3 = new TreeNode(2);
		TreeNode head4 = new TreeNode(1);
		head.left = head1;
		head.right = head2;
		head1.right = head3;
		head3.left = head4;
		
		LogUtils.d(TAG, new TrimaBinarySearchTree().trimBST(head, 1, 3));
	}
}
