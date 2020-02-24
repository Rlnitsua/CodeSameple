package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class UglyNumber {
	private static final String TAG = "UglyNumber";
	
	public boolean isUgly(int num) {
		if(num <= 0){
			return false;
		}else if(num == 1 || num == 2 || num == 3 || num == 5){
			return true;
		}
		
		boolean hasFactor = false;
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				hasFactor = true;
				if(isPrime(i)){
					if(i != 2 && i != 3 && i != 5){
						return false;
					}
				}
				if(isPrime(num/i)){
					if(num/i != 2 && num/i != 3 && num/i != 5){
						return false;
					}
				}
			}
		}
		
		if(!hasFactor){
			return false;
		}else {
			return true;
		}
	}

	private boolean isPrime(int num) {
		for(int i = 2; i < num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new UglyNumber().isUgly(905391974));
//		LogUtils.d(TAG, new UglyNumber().isUgly(14));
	}
}
