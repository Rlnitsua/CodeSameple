package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.util.TreeNode;

public class BalancedBinaryTree {
	private static final String TAG = "BalancedBinaryTree";
	
	public boolean isBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		
		if(Math.abs(nodeDeep(root.left) - nodeDeep(root.right)) < 2){
			return isBalanced(root.left) && isBalanced(root.right);
		}else {
			return false;
		}
	}
	
	private int nodeDeep(TreeNode node){
		int deep = 0;
		if(node == null){
			return deep;
		}else {
			deep++;
			deep += Math.max(nodeDeep(node.left), nodeDeep(node.right));
			return deep;
		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n4.left = n7;
		
/*		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.right = n2;
		n2.right = n3;*/
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new BalancedBinaryTree().isBalanced(n1));
	}
}
