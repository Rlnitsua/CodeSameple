package org.uncle.lee.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.uncle.lee.log.LogUtils;

public class NumberofEquivalentDominoPairs {
	private static final String TAG = "NumberofEquivalentDominoPairs";
	
	public int numEquivDominoPairs(int[][] dominoes) {
		int res = 0;
		Map<int[], Integer> index2Total = new HashMap<>();
		Map<Integer, Integer> index2Index = new HashMap<>();
		
		List<int[]> cache = new ArrayList<>(); 
		for (int i = 0; i < dominoes.length - 1; i++) {
			int currentTotal = 0;
			
			if (isCacheContain(cache, dominoes[i])) {
				int total = 0;
				for (Entry<int[], Integer> entry : index2Total.entrySet()) {
					if (isEqual(entry.getKey(), dominoes[i])) {
						total = entry.getValue();
					}
				}
				res += total - index2Index.get(i);
				continue;
			}
			
			for (int j = i + 1; j < dominoes.length; j++) {
				if (isEqual(dominoes[i], dominoes[j])) {
					cache.add(dominoes[i]);
					currentTotal++;
					index2Index.put(j, currentTotal);
				}
			}
			index2Total.put(dominoes[i], currentTotal);
			res += currentTotal;
		}
		return res;
	}
	
	private boolean isCacheContain(List<int[]> cache, int[] target) {
		for (int[] cacheItem : cache) {
			if (isEqual(cacheItem, target)) {
				return true;
			}
		}
		return false;
	}

	private boolean isEqual(int[] a, int[] b) {
		return (a[0] == b[0] && a[1] == b[1]) 
				|| (a[0] == b[1] && a[1] == b[0]);
	}

	public static void main(String[] args) {
//		int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}, {2, 1}};
		int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}, {1, 2}, {1, 2}, {4, 3}, {6, 7}, {1, 11}};
		NumberofEquivalentDominoPairs dominoPairs = new NumberofEquivalentDominoPairs();
		LogUtils.d(TAG, dominoPairs.numEquivDominoPairs(dominoes));
	}
}
