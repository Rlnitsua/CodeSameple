package org.uncle.lee.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uncle.lee.log.LogUtils;

public class IntersectionofTwoArraysII {
	private static final String TAG = "IntersectionofTwoArraysII";
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> numList = new ArrayList<Integer>();
		int nums1Index = 0;
		for(int nums2Index = 0; nums1Index < nums1.length && nums2Index < nums2.length; ){
			if(nums1[nums1Index] < nums2[nums2Index]){
				nums1Index++;
			}else if (nums1[nums1Index] > nums2[nums2Index]){
				nums2Index++;
			}else {
				numList.add(nums1[nums1Index]);
				nums1Index++;
				nums2Index++;
			}
		}
		
		int[] result = new int[numList.size()];
		for(int i = 0; i < numList.size(); i++){
			result[i] = numList.get(i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new IntersectionofTwoArraysII().intersect(nums1, nums2));
	}
}
