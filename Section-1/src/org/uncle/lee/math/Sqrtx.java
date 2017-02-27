package org.uncle.lee.math;

import org.uncle.lee.log.LogUtils;

public class Sqrtx {
	private static final String TAG = "Sqrtx";
	
	public int mySqrt(int x) {
		boolean isNagetive = false;
		if(x < 0){
			isNagetive = true;
		}
		
		int absX = Math.abs(x);
		int lo = 0;
		int hi = Math.abs(x);
		
		while(lo <= hi){
			long mid = (lo + hi) >> 1;
			if(mid * mid > Math.abs(x)){
				hi = (int) (mid - 1);
			} else if (mid * mid < Math.abs(x)) {
				lo = (int) (mid + 1);
			} else {
				if(isNagetive){
					return (int) (mid * -1);
				}else {
					return (int) mid;
				}
			}
		}
		
		return lo - 1;
	}
	
	public static void main(String[] args) {
//		LogUtils.d(TAG, new Sqrtx().mySqrt(-16));
//		LogUtils.d(TAG, new Sqrtx().mySqrt(0));
//		LogUtils.d(TAG, new Sqrtx().mySqrt(16));
//		LogUtils.d(TAG, new Sqrtx().mySqrt(17));
//		LogUtils.d(TAG, new Sqrtx().mySqrt(26));
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new Sqrtx().mySqrt(2147395599));
	}
}
