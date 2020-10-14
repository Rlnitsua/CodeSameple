package lizbyu.divide;

import java.util.Arrays;

public class Max2 {
	public int[] max2(int[] a, int lo, int hi){
		int result[] = new int[2];
		
		if (lo == hi - 1) {
			result[0] = a[lo];
			result[1] = a[hi];
			return result;
		} else {
			int mid = (lo + hi) >> 1;
			int[] first = max2(a, lo, mid);
			int[] second = max2(a, mid + 1, hi);
			
			if (first[1] > second[0]) {
				result[0] = first[0];
				result[1] = first[1];
			} else {
				if (first[0] > second[0]) {
					result[0] = first[0];
					result[1] = second[0];
				} else {
					if (first[0] > second[1]) {
						result[0] = second[0];
						result[1] = first[0];
					} else {
						result[0] = second[0];
						result[1] = second[1];
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		System.out.println("Max 2 : " + Arrays.toString(new Max2().max2(a, 0, 4)));
	}
}
