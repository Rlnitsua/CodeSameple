package lizbyu.array;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import lizbyu.utils.log.LogUtils;

public class ReshapetheMatrix {
	private static final String TAG = "ReshapetheMatrix";
	
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums == null) {
			return nums;
		}
		int[][] res = new int[r][c];
		
		int originR = nums.length;
		int originC = nums[0].length;
		
		if((originR * originC) != (r * c) || originR == r) {
			return nums;
		} else {
			Queue<Integer> numQueue = getNumQueue(nums);
			doCopy(res, numQueue);
		}
		
		return res;
	}
	
	private Queue<Integer> getNumQueue(int[][] nums) {
		Queue<Integer> numQueue = new LinkedBlockingQueue<>();
		for(int row = 0; row < nums.length; row++) {
			for(int column = 0; column < nums[0].length; column++) {
				numQueue.offer(nums[row][column]);
			}
		}
		return numQueue;
	}
	
	private void doCopy(int[][] res, Queue<Integer> numQueue) {
		for(int row = 0; row < res.length; row++) {
			for(int column = 0; column < res[0].length; column++) {
				res[row][column] = numQueue.poll();
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] nums = {{1, 2, 3}, {4, 5, 6}};
		LogUtils.d(TAG, new ReshapetheMatrix().matrixReshape(nums, 3, 2));
		LogUtils.d(TAG, new ReshapetheMatrix().matrixReshape(nums, 2, 3));
		LogUtils.d(TAG, new ReshapetheMatrix().matrixReshape(nums, 1, 6));
		LogUtils.d(TAG, new ReshapetheMatrix().matrixReshape(nums, 6, 1));
	}
}
