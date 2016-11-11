package org.uncle.lee.divide.and.conquer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than n/2 times.
 */

public class MajorityElement {
	// use double circulation to count every appear of elements
	// bad method
	public int majorityElement_violence(int[] nums) {
		int reslut = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
			if (count > (nums.length / 2)){
				reslut = nums[i];
				break;
			}
		}
		return reslut;
	}
	
	// 33ms in 44 tests [beat 11%]
	// count all appear times of number
	public int majorityElement(int[] nums){
		int result = 0;
		
		// count all appear times of number into one map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			// if not exist, put new situation
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}
			// if exist, add one time and update
			else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		
		// traverse map, if times is bigger than n/2, return the key
		Set<Entry<Integer,Integer>> entrySet = map.entrySet();
		for (Entry<Integer,Integer> entry : entrySet) {
			if (entry.getValue() > (nums.length / 2)){
				result = entry.getKey();
				break;
			}
		}
		
		return result;
	}
	
	public int majorityElement_voting(int[] nums){
		int elem = 0;
		int count = 0;
		
		// traverse all possible person
		for (int i = 0; i < nums.length; i++){
			// no one is holding votes, give votes to next one
			if (count == 0) {
				// write down this person
				elem = nums[i];
				// give one vote to him
				count++;
			} 
			// there's someone holding votes
			else {
				// someone picks elem
				if (elem == nums[i]) {
					// add one vote to elem again
					count++;
				}
				// someone denys elem
				else {
					// delete one vote to elem
					count--;
				}
			}
		}
		return elem;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 3, 4};
//		System.out.println("Majority element : " + new MajorityElement().majorityElement_violence(nums));
//		System.out.println("Majority element : " + new MajorityElement().majorityElement(nums));
		System.out.println("Majority element : " + new MajorityElement().majorityElement_voting(nums));
	}
}
