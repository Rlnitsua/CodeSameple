package org.uncle.lee.divide.and.conquer;

public class Sum {
	public int sum(int[] a, int lo, int hi){
		if (lo == hi) {
			return a[lo];
		} else {
			int mid = (lo + hi) >> 1;
			return sum(a, lo, mid) + sum(a, mid + 1, hi);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("1 + 2 + ... + 9 = " + new Sum().sum(a, 0, 8));		
	}
}
