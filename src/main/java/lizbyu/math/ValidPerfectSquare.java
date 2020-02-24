package lizbyu.math;

import lizbyu.utils.log.LogUtils;

public class ValidPerfectSquare {
	private static final String TAG = "ValidPerfectSquare";
	
	public boolean isPerfectSquare(int num) {
		return searchNum(num, 0, num);
	}
	
	private boolean searchNum(int num, int lo, int hi){
		double mid = 0;
	
		while(lo <= hi){
			mid = (lo + hi) >> 1;
			mid = mid == 0 ? 1 : mid;
			
			if(num / mid > mid){
				lo = (int) mid + 1;
			} else if (num / mid < mid){
				hi = (int) mid - 1;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, new ValidPerfectSquare().isPerfectSquare(16));
		LogUtils.d(TAG, new ValidPerfectSquare().isPerfectSquare(1));
		LogUtils.d(TAG, new ValidPerfectSquare().isPerfectSquare(4));
		LogUtils.d(TAG, new ValidPerfectSquare().isPerfectSquare(7));
	}
}
