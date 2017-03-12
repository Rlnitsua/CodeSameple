package org.uncle.lee.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HitCounter {

	private Map<Integer, Integer> hitHistory;

	/** Initialize your data structure here. */
	public HitCounter() {
		hitHistory = new HashMap<Integer, Integer>();
	}

	/**
	 * Record a hit.
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		if(hitHistory.get(timestamp) != null){
			hitHistory.put(timestamp, hitHistory.get(timestamp) + 1);
		} else {
			hitHistory.put(timestamp, 1);
		}
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int count = 0;
		for(Entry<Integer, Integer> entry : hitHistory.entrySet()){
			if(entry.getKey() > timestamp - 300 && entry.getKey() <= timestamp){
				count += entry.getValue();
			}
		}
		return count;
	}
}
