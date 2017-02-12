package org.uncle.lee.binary.tree;

import org.uncle.lee.log.LogUtils;
import org.uncle.lee.util.TreeNode;

public class SymmetricTree {
	private static final String TAG = "SymmetricTree";
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}else {
			return isSymmetricNodePairs(root.left, root.right);
		}
	}
	
	private boolean isSymmetricNodePairs(TreeNode n1, TreeNode n2){
		if(n1 == null && n2 == null){
			return true;
		}else if((n1 == null && n2 != null) ||
				(n1 != null && n2 == null)){
			return false;
		}else {
			if(n1.val != n2.val){
				return false;
			}else {
				return isSymmetricNodePairs(n1.left, n2.right) && 
						isSymmetricNodePairs(n1.right, n2.left);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(6);
		TreeNode n10 = new TreeNode(7);
		TreeNode n11 = new TreeNode(7);
		TreeNode n12 = new TreeNode(6);
		TreeNode n13 = new TreeNode(51);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		n5.right = n10;
		n6.left = n11;
		n7.left = n12;
		n7.right = n13;
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new SymmetricTree().isSymmetric(n1));
	}
}
