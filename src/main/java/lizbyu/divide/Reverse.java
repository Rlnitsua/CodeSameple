package lizbyu.divide;

import java.util.Arrays;

/*
 * Reverse array
 * decrease and conquer
 */

public class Reverse {
	public void reverse(int[] a, int lo, int hi) {
		// if lo < hi, it means that the array has elements.
		if (lo < hi) {
			// do reverse
			swap(a, lo, hi);
			// decrease scale, a[lo] and a[hi] have been handled
			// only handle [lo+1, hi-1]
			reverse(a, lo + 1, hi - 1);
		}
	}

	// do swap
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
