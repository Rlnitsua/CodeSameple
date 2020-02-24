package lizbyu.hash.table;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays_opt {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> intersectionSet = new HashSet<Integer>();
		
		for(int i = 0; i < nums1.length; i++){
			set1.add(nums1[i]);
		}
		
		for(int i = 0; i < nums2.length; i++){
			if(set1.contains(nums2[i])){
				intersectionSet.add(nums2[i]);
			}
		}
		
		int[] result = new int[intersectionSet.size()];
		int index = 0;
		for(Integer num : intersectionSet){
			result[index++] = num;
		}
		
		return result;
	}
}
