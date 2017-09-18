package org.uncle.lee.hash.table;

import java.util.HashMap;
import java.util.Map;

import org.uncle.lee.log.LogUtils;

public class MapSumPairs {
	private static final String TAG = "MapSumPairs";
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("a", 3);
		LogUtils.d(TAG, map.get("a"));
	}
}

class MapSum {
	private Map<String, Integer> map;

	/** Initialize your data structure here. */
	public MapSum() {
		map = new HashMap<>();
	}

	public void insert(String key, int val) {
		map.put(key, val);
	}

	public int sum(String prefix) {
		int sum = 0;
		for (String key : map.keySet()) {
			if (key.startsWith(prefix)) {
				sum += map.get(key);
			}
		}
		return sum;
	}
}