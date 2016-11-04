package org.uncle.lee.easy;

import java.util.Arrays;

public class Max2 {
	public int[] findMax2(int[] a) {
		int[] result = new int[2];

		// traverse one time to find biggest element
		for (int i = 0; i < a.length - 1; i++) {
			result[0] = a[i] > a[i + 1] ? a[i] : a[i + 1];
		}
		
		// traverse one time again to find second biggest element
		for (int i = 0; i < a.length - 2; i++) {
			result[1] = a[i] > a[i + 1] ? a[i] : a[i + 1];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("Max 2 : " + Arrays.toString(new Max2().findMax2(a)));
	}
}
