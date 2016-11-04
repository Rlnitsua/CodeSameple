package org.uncle.lee.divide.and.conquer;

import java.util.Arrays;

public class Reverse {
	public void reverse(int[] a, int lo, int hi) {
		if (lo < hi) {
			swap(a, lo, hi);
			reverse(a, lo + 1, hi - 1);
		}
	}

	private void swap(int[] a, int lo, int hi) {
		int temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		new Reverse().reverse(a, 0, 6);
		System.out.println("Reverse int[] : " + Arrays.toString(a));
	}
}
