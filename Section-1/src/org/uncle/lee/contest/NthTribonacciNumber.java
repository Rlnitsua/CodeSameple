package org.uncle.lee.contest;

import java.util.HashMap;
import java.util.Map;

import org.uncle.lee.log.LogUtils;

public class NthTribonacciNumber {
	public int tribonacci(int n) {
		Map<Integer, Integer> map = calculateMap(n);
		return map.get(n);
	}

	private Map<Integer, Integer> calculateMap(int n) {
		Map<Integer, Integer> res = new HashMap<>();
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				res.put(0, 0);
			} else if (i == 1) {
				res.put(1, 1);
			} else if (i == 2) {
				res.put(2, 1);
			} else {
				int num = res.get(i - 1) + res.get(i - 2) + res.get(i - 3);
				res.put(i, num);
			}
		}
		return res;
	}
	
	public int tribonacci0(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else if (n ==2) {
			return 1;
		}
		return tribonacci0(n - 1) + tribonacci0(n - 2) + tribonacci0(n - 3);
	}
	
	public static void main(String[] args) {
		LogUtils.d("NthTribonacciNumber", "~~~");
		NthTribonacciNumber nthTribonacciNumber = new NthTribonacciNumber();
//		LogUtils.d("NthTribonacciNumber", nthTribonacciNumber.tribonacci(4));
		LogUtils.d("NthTribonacciNumber", nthTribonacciNumber.tribonacci(25));
	}
}
