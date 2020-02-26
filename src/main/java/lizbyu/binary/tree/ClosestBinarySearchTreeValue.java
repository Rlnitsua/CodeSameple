package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class ClosestBinarySearchTreeValue {
	private static final String TAG = "ClosestBinarySearchTreeValue";

	public int closestValue(TreeNode root, double target) {
		int rootVal = root.val;
		TreeNode closeChlid = target < rootVal ? root.left : root.right;
		if(closeChlid == null){
			return rootVal;
		}
		int closeChlidDeep = closestValue(closeChlid, target);
		return Math.abs(rootVal - target) < Math.abs(closeChlidDeep - target) 
				? rootVal : closeChlidDeep;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(36);
		TreeNode node2 = new TreeNode(13);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(20);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(5);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(3);

		node1.left = node2;
		node2.left = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		node5.right = node7;
		node7.right = node8;

		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new ClosestBinarySearchTreeValue().closestValue(node1,
				3.142857));
	}
}
