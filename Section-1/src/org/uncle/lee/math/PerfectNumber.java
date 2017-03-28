package org.uncle.lee.math;

public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		if(num <= 0 || num == 1){
			return false;
		}
		
		int sum = 1;
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				sum += i;
				sum += (num / i);
			}
		}
		return num == sum;
	}
}
