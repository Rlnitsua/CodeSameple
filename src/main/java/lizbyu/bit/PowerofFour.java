package lizbyu.bit;

import lizbyu.utils.log.LogUtils;

public class PowerofFour {
	private static final String TAG = "PowerofFour";
	
	public boolean isPowerOfFour(int num) {
		return num > 0 && Integer.bitCount(num) == 1 && Integer.bitCount(num - 1) % 2 == 0;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new PowerofFour().isPowerOfFour(16));
		LogUtils.d(TAG, new PowerofFour().isPowerOfFour(2));
	}
}
