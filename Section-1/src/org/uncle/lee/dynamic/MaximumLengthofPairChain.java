package org.uncle.lee.dynamic;

/*
you are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. 
Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. 
You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].
*/

public class MaximumLengthofPairChain {
	public int findLongestChain(int[][] pairs) {
		doSort(pairs);
		
		int res = 0;
		
		int currentLeft = pairs[0][0];
		while(isPairExist(currentLeft, pairs)) {
			int leftNum = getCurrentPair(currentLeft, pairs)[0];
			int rightNum = getCurrentPair(currentLeft, pairs)[1];
			int findGapNum = findGapNum(leftNum, rightNum, pairs);
			
			if (findGapNum > 1) {
				res += findGapNum;
			} else {
				res += 1;
			}
			
			currentLeft = rightNum;
		}
		
		return res;
	}
	
	private void doSort(int[][] pairs) {
		
	}

	private boolean isPairExist(int startNum, int[][] pairs) {
		return getCurrentPair(startNum, pairs) != null;
	}
	
	private int[] getCurrentPair(int startNum, int[][] pairs) {
		for (int i = 0; i < pairs.length; i++) {
			if (pairs[i][0] == startNum) {
				return pairs[i];
			}
		}
		return null;
	}

	private int findGapNum(int i, int j, int[][] pairs) {
		int num = 0;
		for (int index = 0; i < pairs.length; i++) {
			if (pairs[0][index] == i && pairs[1][index] == j) {
				continue;
			}
			
			if (pairs[0][index] <= i && pairs[1][index] >= j) {
				num++;
			}
			
			if (pairs[0][index] > i) {
				break;
			}
		}
		return num;
	}
}
