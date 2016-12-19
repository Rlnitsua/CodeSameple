package org.uncle.lee.hash.table;

public class SingleNumber_opt {
	public int singleNumber(int[] nums) {
		int singleNumber = 0;
		for(int number : nums){
			singleNumber ^= number;
		}
		return singleNumber;
	}
}
