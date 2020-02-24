package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class MaximumSwap {
	private static final String TAG = "MaximumSwap";
	
	public int maximumSwap(int num) {
		int[] numArr = getNumArr(num);
		
		for (int i = 0; i < numArr.length; i++) {
			if (hasResult(numArr, i)) {
				return calculateResult(numArr, i);
			}
		}
		return num;
	}
	
	private int[] getNumArr(int num) {
		char[] numChArr = String.valueOf(num).toCharArray();
		int[] numArr = new int[numChArr.length];
		for (int i = 0; i < numChArr.length; i++) {
			numArr[i] = Integer.valueOf(numChArr[i] + "");
		}
		return numArr;
	}
	
	private boolean hasResult(int[] numArr, int i) {
		for (int j = i; j < numArr.length; j++) {
			if (numArr[j] > numArr[i]) {
				return true;
			}
		}
		return false;
	}
	
	private int calculateResult(int[] numArr, int i) {
		int max = numArr[i];
		int maxIndex = i;
		for (int j = i; j < numArr.length; j++) {
			if (numArr[j] > numArr[i]) {
				if (numArr[j] >= max) {
					max = numArr[j];
					maxIndex = j;
				}
			}
		}
		
		return swapAndCalculate(numArr, i, maxIndex);
	}

	private int swapAndCalculate(int[] numArr, int i, int maxIndex) {
		int temp = numArr[i];
		numArr[i] = numArr[maxIndex];
		numArr[maxIndex] = temp;
		
		StringBuffer sb = new StringBuffer();
		for (int num : numArr) {
			sb.append(String.valueOf(num));
		}
		return Integer.valueOf(new String(sb));
	}

	public static void main(String[] args) {
		int num = 1993;
		LogUtils.d(TAG, new MaximumSwap().maximumSwap(num));
	}
}
