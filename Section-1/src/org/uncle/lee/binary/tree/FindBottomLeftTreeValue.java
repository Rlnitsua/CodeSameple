package org.uncle.lee.binary.tree;

import org.uncle.lee.log.LogUtils;
import org.uncle.lee.util.TreeNode;

public class FindBottomLeftTreeValue {
	private static final String TAG = "FindBottomLeftTreeValue";
	private int maxDeep = -1;
	private int value = 0;
	
	
	public int findBottomLeftValue(TreeNode root) {
		getLeftValue(root, 0);
		return value;
	}
	
	public void getLeftValue(TreeNode root, int deep){
		if(root == null){
			return;
		}
		
		if(root.left == null && root.right == null){
			if(maxDeep == -1){
				maxDeep = deep;
				value = root.val;
			} else {
				if(maxDeep < deep){
					value = root.val;
					maxDeep = deep;
				}
			}
		} else {
			getLeftValue(root.left, deep + 1);
			getLeftValue(root.right, deep + 1);
		}
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		
		node.left = node1;
		node.right = node2;
		
		LogUtils.d(TAG, new FindBottomLeftTreeValue().findBottomLeftValue(node));
	}
}
