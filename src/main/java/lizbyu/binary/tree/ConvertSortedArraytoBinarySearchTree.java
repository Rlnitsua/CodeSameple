package lizbyu.binary.tree;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.node.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	private static final String TAG = "ConvertSortedArraytoBinarySearchTree";
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0){
			return null;
		}
		
		TreeNode root = getRoot(nums, 0, nums.length - 1);
		return root;
	}
	
	private TreeNode getRoot(int[] nums, int low, int high) {
		if(low > high){
			return null;
		}
		
		int mid = (low + high) >> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = getRoot(nums, low, mid - 1);
		root.right = getRoot(nums, mid + 1, high);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		LogUtils.d(TAG, new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(nums));
	}
}
