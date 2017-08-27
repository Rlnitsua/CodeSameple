package org.uncle.lee.binary.tree;

import java.util.List;

import org.uncle.lee.util.TreeNode;

public class PrintBinaryTree {
	public List<List<String>> printTree(TreeNode root) {
		int deep = getTreeDeep(root);
		int maxLength = getMaxLength(deep);
		
		return null;
	}
	
	private int getTreeDeep(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return Math.max(getTreeDeep(root.left) + 1, getTreeDeep(root.right) + 1);
	}
	
	private int getMaxLength(int deep) {
		if(deep == 1) {
			return 1;
		}
		
		return (int) (Math.pow(2, deep -1) + getMaxLength(deep - 1));
	}
}
