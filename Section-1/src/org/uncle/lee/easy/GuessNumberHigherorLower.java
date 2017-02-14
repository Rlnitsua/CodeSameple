package org.uncle.lee.easy;

public class GuessNumberHigherorLower {
	public int guessNumber(int n) {
		
		int lo = 0;
		int hi = n;
		
		while(lo < hi){
			int mid = (lo + hi) >> 1;
		
			if(guess(mid) < 0){
				lo = n + 1;
			} else if (guess(mid) > 0){
				hi = n - 1;
			} else {
				return mid;
			}
		}
		
		return 0;
	}

	private int guess(int mid) {
		return 0;
	}
}
