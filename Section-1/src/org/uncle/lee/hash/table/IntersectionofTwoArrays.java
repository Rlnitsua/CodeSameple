package org.uncle.lee.hash.table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.uncle.lee.log.LogUtils;

public class IntersectionofTwoArrays {
	private static final String TAG = "IntersectionofTwoArrays";
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		Set<Integer> intersectionSet = new HashSet<Integer>();
		int nums1Index = 0;
		for(int nums2Index = 0; nums1Index < nums1.length && nums2Index < nums2.length; ){
			if(nums1[nums1Index] < nums2[nums2Index]){
				nums1Index++;
			}else if(nums1[nums1Index] > nums2[nums2Index]){
				nums2Index++;
			}else {
				intersectionSet.add(nums1[nums1Index]);
				nums1Index++;
				nums2Index++;
			}
		}
		
		int[] resultArray = getArrayFromSet(intersectionSet);
		return resultArray;
	}

	private int[] getArrayFromSet(Set<Integer> intersectionSet) {
		int[] resultArray = new int[intersectionSet.size()];
		int index = 0;
		for(Integer num : intersectionSet){
			resultArray[index] = num;
			index++;
		}
		return resultArray;
	}
	
	public static void main(String[] args) {
		int nums1[] = {1, 2, 2, 1};
		int nums2[] = {2, 2};
		
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new IntersectionofTwoArrays().intersection(nums1, nums2));
	}
}
