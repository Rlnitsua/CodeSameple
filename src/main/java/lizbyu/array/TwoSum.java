package lizbyu.array;

import java.util.Arrays;

import lizbyu.utils.log.LogUtils;

public class TwoSum {
	private static final String TAG = "TwoSum";
	
	public int[] twoSum0(int[] nums, int target) {
		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		int[] res = new int[2];
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if (nums[i] + nums[j] < target){
					if(j == nums.length - 1){
						break;
					}else {
						if(nums[i] + nums[j + 1] < target){
							continue;
						} else if (nums[i] + nums[j + 1] > target) {
							break;
						} else {
							res[0] = nums[i];
							res[1] = nums[j + 1];
						}
					}
				} else if (nums[i] + nums[j] > target){
					break;
				} else {
					res[0] = nums[i];
					res[1] = nums[j];
				}
			}
		}
		
		for(int i = 0; i < numsCopy.length; i++){
			if(numsCopy[i] == res[0]){
				res[0] = i;
				break;
			}
		}
		
		for(int i = 0; i < numsCopy.length; i++){
			if(i != res[0] && numsCopy[i] == res[1]){
				res[1] = i;
				break;
			}
		}
		
		return res;
	}
	
	private int[] res = new int[2];
	public int[] twoSum(int[] nums, int target) {
		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			if(existRes(Arrays.copyOfRange(nums, i, nums.length), target - nums[i])){
				res[0] = nums[i];
				res[1] = target - nums[i];
				break;
			}
		}
		
		for(int i = 0; i < numsCopy.length; i++){
			if(numsCopy[i] == res[0]){
				res[0] = i;
				break;
			}
		}
		
		for(int i = 0; i < numsCopy.length; i++){
			if(i != res[0] && numsCopy[i] == res[1]){
				res[1] = i;
				break;
			}
		}
		return res;
	}

	private boolean existRes(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;
		
		while(lo <= hi){
			int mid = (lo + hi) >> 1;
			if(nums[mid] > target){
				hi = mid - 1;
			} else if (nums[mid] < target){
				lo = mid + 1;
			} else {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
//		int[] nums = {3, 2, 4};
		int[] nums = {3, 3};
//		int[] nums = {-1,-2,-3,-4,-5};
		LogUtils.d(TAG, new TwoSum().twoSum(nums, 6));
	}
}
