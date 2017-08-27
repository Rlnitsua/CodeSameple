package org.uncle.lee.hash.table;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
		int[] res = new int[2];
		
		int count = nums.length;
		int targetSum = 0, realSum = 0;
		Set<Integer> set = new HashSet<>();
		
		for(int i = 1; i <= count; i++) {
			targetSum += i;
		}
		
		for(int num : nums) {
			if(set.add(num)) {
				realSum += num;
			} else {
				res[0] = num;
			}
		}
		
		res[1] = targetSum - realSum;
		
		return res;
	}
}
