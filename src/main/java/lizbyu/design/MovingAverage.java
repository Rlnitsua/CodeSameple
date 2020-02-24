package lizbyu.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import lizbyu.utils.log.LogUtils;

public class MovingAverage {
	private static final String TAG = "MovingAverage";
	
	private Queue<Integer> queue;
	private int maxSize = 0;
	
	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		maxSize = size;
		queue = new LinkedBlockingQueue<Integer>();
	}

	public double next(int val) {
		if(queue.size() == maxSize){
			queue.poll();
		}
		queue.offer(val);
		
		double sum = 0.0;
		List<Integer> numList = new ArrayList<Integer>();
		numList.addAll(queue);
		for(int num : numList){
			sum += num;
		}
		
		return sum / queue.size();
	}
	
	public static void main(String[] args) {
		MovingAverage movingAverage = new MovingAverage(3);
		LogUtils.d(TAG, movingAverage.next(1));
		LogUtils.d(TAG, movingAverage.next(10));
		LogUtils.d(TAG, movingAverage.next(3));
		LogUtils.d(TAG, movingAverage.next(5));
	}
}