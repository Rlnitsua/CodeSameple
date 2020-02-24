package lizbyu.dynamic;

import lizbyu.utils.log.LogUtils;

public class ClimbingStairs {
	private static final String TAG = "ClimbingStairs";
	
	public int climbStairs(int n) {
		if(n <= 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		
		int oneStepBefore = 2;
		int twoStepsBefore = 1;
		int febonacci = 0;
		for(int i = 2; i < n; i++){
			febonacci = oneStepBefore + twoStepsBefore;
			// for next traverse
			twoStepsBefore = oneStepBefore;
			oneStepBefore = febonacci;
		}
		
		return febonacci;
	}
	
	public static void main(String[] args) {
		LogUtils.d(TAG, "start");
		LogUtils.d(TAG, new ClimbingStairs().climbStairs(44));
	}
}
