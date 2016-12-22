package org.uncle.lee.math;

import java.util.HashSet;
import java.util.Set;

import org.uncle.lee.log.LogUtils;

public class HappyNumber_opt {
	private static final String TAG = "HappyNumber_opt";
	
	public boolean isHappy(int n) {
		int sum;
		Set<Integer> happyNumSet = new HashSet<Integer>();
		while(happyNumSet.add(n)){
			sum = 0;
			while(n >= 1){
				sum += (n % 10) * (n % 10);
				n /= 10;
			}
			
			if(sum == 1){
				return true;
			}else {
				n = sum;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new HappyNumber_opt().isHappy(19));
		LogUtils.d(TAG, new HappyNumber_opt().isHappy(7));
		LogUtils.d(TAG, new HappyNumber_opt().isHappy(71));
	}
}
