package org.uncle.lee.easy;

import org.uncle.lee.log.LogUtils;

public class GuessNumberHigherorLower {
	private static final String TAG = "GuessNumberHigherorLower";
//	private final int MY_NUMBER = 2126753390;
	private final int MY_NUMBER = 6;
	
	public int guessNumber(int n) {
		int lo = 0;
		int hi = 0;
		int mid = n;
		
		while(true){
			if(guess(mid) > 0){
				lo = mid;
				
				if(hi == 0){
					mid *= 2;
				} else {
					mid = getMid(lo, hi);
				}
			} else if (guess(mid) < 0){
				hi = mid;
				
				if(lo == 0){
					mid /= 2;
				} else {
					mid = getMid(lo, hi);
				}
			} else {
				return mid;
			}
		}
	}

	private int getMid(int lo, int hi) {
		if(lo % 2 != 0 && hi % 2 != 0){
			return ((lo + 1) >> 1) + (hi >> 1);
		} else {
			return (lo >> 1) + (hi >> 1);
		}
	}

	private int guess(int guessNumber) {
		if(MY_NUMBER < guessNumber){
			return -1;
		} else if (MY_NUMBER > guessNumber){
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
//		LogUtils.d(TAG, new GuessNumberHigherorLower().guessNumber(1702766719));
		LogUtils.d(TAG, new GuessNumberHigherorLower().guessNumber(10));
	}
}
