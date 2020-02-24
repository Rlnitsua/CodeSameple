package lizbyu.binary.tree;

public class SameTree {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true;
		}

		if((p == null && q != null) || (p != null && q == null)){
			return false;
		}else {
			if(p.val != q.val){
				return false;
			}
		}
		
		if((p.left == null && q.left != null) || (p.left != null && q.left == null)){
			return false;
		}
		if((p.right == null && q.right != null) || (p.right != null && q.right == null)){
			return false;
		}
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
