package lizbyu.binary.tree;

import java.util.Arrays;

import lizbyu.utils.log.LogUtils;
import lizbyu.utils.util.TreeNode;

public class MaximumBinaryTree {
	private static final String TAG = "MaximumBinaryTree";
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums == null) {
			return null;
		}
		
		int startIndex = 0;
		int endIndex = nums.length - 1;
		
		int maxIndex = findMax(nums, startIndex, endIndex);
		TreeNode head = new TreeNode(nums[maxIndex]);
		
		if(maxIndex == startIndex) {
			head.left = null;
		} else {
			head.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, startIndex, maxIndex));
		}
		
		if(maxIndex == endIndex) {
			head.right = null;
		} else {
			head.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
		}
		
		return head;
	}
	
	public int findMax(int[] arr, int startIndex, int endIndex) {
		int max = Integer.MIN_VALUE;
		for(int i = startIndex; i <= endIndex; i++) {
			max = Math.max(arr[i], max);
		}
		
		for(int i = startIndex; i <= endIndex; i++) {
			if(max == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3, 2, 1, 6, 0, 5};
		TreeNode constructMaximumBinaryTree = new MaximumBinaryTree().constructMaximumBinaryTree(arr);
		LogUtils.d(TAG, constructMaximumBinaryTree);
	}
}
