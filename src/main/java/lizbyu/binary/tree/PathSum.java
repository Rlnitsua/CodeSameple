package lizbyu.binary.tree;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.node.TreeNode;

public class PathSum {
	List<Integer> list = new ArrayList<Integer>();
	public boolean hasPathSum0(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		
		calculateSum(root, 0);
		return list.contains(sum);
	}
	
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null && sum - root.val == 0){
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	private void calculateSum(TreeNode root, int sum) {
		sum += root.val;
		
		if(root.left == null && root.right == null){
			list.add(sum);
		} else if (root.left != null && root.right == null){
			calculateSum(root.left, sum);
		} else if (root.left == null && root.right != null){
			calculateSum(root.right, sum);
		} else {
			calculateSum(root.left, sum);
			calculateSum(root.right, sum);
		}
	}
}
