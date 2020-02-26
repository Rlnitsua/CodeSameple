package lizbyu.binary.tree;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class FindLeavesofBinaryTree {
	private static final String TAG = "FindLeavesofBinaryTree";
	
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> leaves = new ArrayList<Integer>();
		
		if((leaves = getLeaves(root, leaves)) != null){
			res.add(leaves);
		}
		
		return res;
	}

	private List<Integer> getLeaves(TreeNode root, List<Integer> leaves) {
		if(root == null){
			return null;
		}
		if(root.left == null && root.right == null){
			leaves.add(root.val);
			// delete this node
			root = null;
//			root.val = -1;
		} else {
			getLeaves(root.left, leaves);
			getLeaves(root.right, leaves);
		}
		return leaves;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		LogUtils.d(TAG, new FindLeavesofBinaryTree().findLeaves(root));
	}
}
