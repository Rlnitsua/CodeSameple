package lizbyu.binary.tree;

import java.util.ArrayList;
import java.util.List;

import lizbyu.utils.log.LogUtils;

/*
If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.

The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. 
The position is the same as that in a full binary tree.

The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. 
You need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:
Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.
*/

public class PathSumIV {
	private static final String TAG = "PathSumIV";
	
	public int pathSum(int[] nums) {
		List<Integer> noteList = new ArrayList<>();
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= Math.pow(2, i - 1); j++) {
				if (hasNode(i, j, nums) && hasNoChild(i, j, nums)) {
					noteList.add(getCurrentNode(i, j, nums));
				}
			}
		}
		
		int res = 0;
		for (int note : noteList) {
			res += calculateNotePathSum(note, nums);
		}
		
		return res;
	}

	private boolean hasNoChild(int i, int j, int[] nums) {
		int leftChild = (i + 1) * 10 + (2 * j - 1);
		int rightChild = (i + 1) * 10 + (2 * j);
		for (int num : nums) {
			if ((num / 10) == leftChild || (num / 10) == rightChild) {
				return false;
			}
		}
		return true;
	}
	
	private boolean hasNode(int i, int j, int[] nums) {
		return getCurrentNode(i, j, nums) != -1;
	}

	private Integer getCurrentNode(int i, int j, int[] nums) {
		int index = i * 10 + j;
		for (int num : nums) {
			if ((num / 10) == index) {
				return num;
			}
		}
		return -1;
	}
	
	private int calculateNotePathSum(int note, int[] nums) {
		int floor = note / 100;
		int index = (note / 10) % 10;
		
		int sum = note % 10;
		if (floor == 1) {
			return sum;
		}

		
		for (int i = floor - 1; i >= 1; i--) {
			index = (index + 1) >> 1;
			sum += getCurrentNode(i, index, nums) % 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		PathSumIV sum = new PathSumIV();
//		int[] nums = new int[] {113, 215, 221};
		int[] nums = new int[] {115,215,224,325,336,446,458};
		LogUtils.d(TAG, sum.pathSum(nums));
	}
}
