package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class EqualTreePartition {
	private static final String TAG = "EqualTreePartition";
	private int totalCount = 0;
	
	public boolean checkEqualTree(TreeNode root) {
		totalCount = getCount(root);
		return visit(root, 0);
	}
	
	private boolean visit(TreeNode head, int num) {
		if(head == null) {
			return false;
		}
		if(head.left == null && head.right == null) {
			return false;
		}
		
		if(totalCount == 2 * getCount(head.right) ||
				totalCount == 2 * getCount(head.left)) {
			return true;
		} else {
			return visit(head.left, num + head.val) || visit(head.right, num + head.val);
		}
	}
	
	private int getCount(TreeNode head) {
		if(head == null) {
			return 0;
		}
		
		int count = 0;
		count += head.val;
		count += getCount(head.left);
		count += getCount(head.right);
		return count;
	}
	
	public static void main(String[] args) {
//		TreeNode head = new TreeNode(5);
//		TreeNode headL = new TreeNode(10);
//		TreeNode headR = new TreeNode(10);
//		TreeNode node1L = new TreeNode(2);
//		TreeNode node1R = new TreeNode(3);
//		
//		head.left = headL;
//		head.right = headR;
//		headR.left = node1L;
//		headR.right = node1R;
		
//		TreeNode head = new TreeNode(1);
//		TreeNode headL = new TreeNode(2);
//		TreeNode headR = new TreeNode(10);
//		TreeNode node1L = new TreeNode(2);
//		TreeNode node1R = new TreeNode(20);
//		
//		head.left = headL;
//		head.right = headR;
//		headR.left = node1L;
//		headR.right = node1R;
		
		TreeNode head = new TreeNode(2);
		TreeNode head1 = new TreeNode(1);
		TreeNode head2 = new TreeNode(3);
		TreeNode head3 = new TreeNode(0);
		TreeNode head4 = new TreeNode(2);
		TreeNode head5 = new TreeNode(2);
		TreeNode head6 = new TreeNode(1);
		TreeNode head7 = new TreeNode(1);
		
		head.left = head1;
		head.right = head2;
		head1.left = head3;
		head1.right = head4;
		head4.left = head5;
		head5.left = head6;
		head6.right = head7;
		
		LogUtils.d(TAG, new EqualTreePartition().checkEqualTree(head));
	}
}
