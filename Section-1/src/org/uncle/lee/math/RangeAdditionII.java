package org.uncle.lee.math;

import org.uncle.lee.log.LogUtils;

public class RangeAdditionII {
	private static final String TAG = "RangeAdditionII";
	
	public int maxCount(int m, int n, int[][] ops) {
		int minX = m;
		int minY = n;
		
		if(ops == null || ops.length == 0) {
			return minX * minY;
		}
		
		for(int i = 0; i < ops.length; i++) {
			minX = Math.min(minX, ops[i][0]);
			minY = Math.min(minY, ops[i][1]);
		}
		
		return minX * minY;
	}
	
	public static void main(String[] args) {
		int m = 3, n = 3;
		int[][] ops = {{2, 2}, {3, 1}};
		LogUtils.d(TAG, new RangeAdditionII().maxCount(m, n, ops));
	}
}
