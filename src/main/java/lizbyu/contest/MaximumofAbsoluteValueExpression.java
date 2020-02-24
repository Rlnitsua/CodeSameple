package lizbyu.contest;

import lizbyu.utils.log.LogUtils;

public class MaximumofAbsoluteValueExpression {
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		int res = -1;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				int val = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j])
					+ Math.abs(i - j);
				res = Math.max(res, val);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,-2,-5,0,10};
		int[] arr2 = {0,-2,-1,-7,-4};
		MaximumofAbsoluteValueExpression expression = new MaximumofAbsoluteValueExpression();
		LogUtils.d("MaximumofAbsoluteValueExpression", expression.maxAbsValExpr(arr1, arr2));
	}
}
