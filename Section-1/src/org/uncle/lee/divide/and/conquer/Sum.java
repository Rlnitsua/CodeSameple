package org.uncle.lee.divide.and.conquer;

/*
 * divide and conquer
 */

public class Sum {
	public int sum(int[] a, int lo, int hi){
		// if lo == hi, it means that two pointers point to one element
		if (lo == hi) {
			return a[lo];
		} else {
			// find mid position, split one array to two sequences
			int mid = (lo + hi) >> 1;
			// calculate each sequence and add both of them
			return sum(a, lo, mid) + sum(a, mid + 1, hi);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("1 + 2 + ... + 9 = " + new Sum().sum(a, 0, 8));		
	}
}
