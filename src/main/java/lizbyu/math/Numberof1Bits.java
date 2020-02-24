package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class Numberof1Bits {
	private static final String TAG = "Numberof1Bits";
	
	public int hammingWeight0(int n) {
		return Integer.bitCount(n);
	}
	
	public int hammingWeight(int n) {
		int count = 0;
		
		while(n != 0){
			count += n & 1;
			n >>>= 1;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, Integer.bitCount(499999995));
		LogUtils.d(TAG, "start");
//		LogUtils.d(TAG, new Numberof1Bits().hammingWeight(2147483648));
	}
}
