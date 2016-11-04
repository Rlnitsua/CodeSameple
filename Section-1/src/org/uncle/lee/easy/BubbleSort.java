package org.uncle.lee.easy;

import java.util.Arrays;

public class BubbleSort {
	public int[] sort(int[] datas) {
		int length = datas.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (datas[j] > datas[j + 1]) {
					swap(datas, j, j + 1);
				}
			}
		}
		return datas;
	}

	private void swap(int[] datas, int j, int i) {
		int temp = datas[j];
		datas[j] = datas[j + 1];
		datas[j + 1] = temp;
	}

	public static void main(String[] args) {
		int[] datas = { 3, 2, 8, 1, 9, 5, 4, 7, 6 };
		int[] sortedDatas = new BubbleSort().sort(datas);
		System.out.println("sorted datas : " + Arrays.toString(sortedDatas));
	}
}
