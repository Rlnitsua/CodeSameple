package org.uncle.lee.binary.tree;

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		if(root.left == null && root.right == null){
			return root.val;
		}else if(root.left == null){
			if(Math.abs(root.right.val - target) < Math.abs(root.val - target)){
				return closestValue(root.right, target);
			}else {
				return root.val;
			}
		}else if(root.right == null){
			if(Math.abs(root.left.val - target) < Math.abs(root.val - target)){
				return closestValue(root.left, target);
			}else {
				return root.val;
			}
		}
		
		if(Math.abs(root.right.val - target) < Math.abs(root.val - target)){
			return closestValue(root.right, target);
		}else {
			if(root.val <= target){
				return root.val;
			}else {
				if(Math.abs(root.left.val - target) < Math.abs(root.val - target)){
					return closestValue(root.left, target);
				}else {
					return root.val;
				}
			}
		}
	}
}
