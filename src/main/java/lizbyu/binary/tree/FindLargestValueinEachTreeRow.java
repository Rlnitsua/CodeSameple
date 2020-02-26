package lizbyu.binary.tree;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class FindLargestValueinEachTreeRow {
	private static final String TAG = "FindLargestValueinEachTreeRow";
	
	List<Integer> res = new ArrayList<>();
	
	public List<Integer> largestValues(TreeNode root) {
		traverseDfs(root, 0);
		return res;
	}

	private void traverseDfs(TreeNode root, int deep) {
		if(root == null){
			return;
		}
		deep++;
		if(res.size() < deep){
			res.add(root.val);
		}
		traverseDfs(root.left, deep);
		traverseDfs(root.right, deep);
		
		res.set(deep - 1, root.val > res.get(deep - 1) ? root.val : res.get(deep - 1));
	}
	
	public void traverseDfs(TreeNode root){
		if(root == null){
			return;
		}
		traverseDfs(root.left);
		traverseDfs(root.right);
		// handle...
		LogUtils.d(TAG, root.val);
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;

//		new FindLargestValueinEachTreeRow().traverseDfs(node);
		LogUtils.d(TAG, new FindLargestValueinEachTreeRow().largestValues(node));

	}
	
}
