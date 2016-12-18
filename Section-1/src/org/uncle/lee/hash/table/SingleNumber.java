package org.uncle.lee.hash.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
		for(int index = 0; index < nums.length; index++){
			int numberCount = integerMap.get(nums[index]) == null ? 0 : integerMap.get(nums[index]);
			integerMap.put(nums[index], ++numberCount);
		}
		
		int singleNumber = 0;
		for(Entry<Integer, Integer> entry : integerMap.entrySet()){
			if(entry.getValue() == 1){
				singleNumber = entry.getKey();
				break;
			}
		}
		
		return singleNumber;
	}
	
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(new SingleNumber().singleNumber(nums));
	}
}
