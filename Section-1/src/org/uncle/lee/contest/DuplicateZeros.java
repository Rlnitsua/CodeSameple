package org.uncle.lee.contest;

import java.util.ArrayList;
import java.util.List;

public class DuplicateZeros {
	public void duplicateZeros(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (Integer num : arr) {
			list.add(num);
			if (num == 0) {
				list.add(num);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
	}
}
