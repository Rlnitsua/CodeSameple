package lizbyu.array;

import java.util.Arrays;

/*
 * The same as remove function of vector
 */

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		// real index of nums[]
		int index = 0;
		// guard of nums
		int guard = 0;
		
		// traverse all nums and assign value again
		while(index < nums.length){
			// if guard == nums.length, it means that all nums left are zeros
			if(guard == nums.length){
				nums[index] = 0;
				index++;
			}
			// there are some nums which is not zero
			else {
				while(guard < nums.length){
					// if nums[guard] == 0, jump over it
					if(nums[guard] == 0){
						guard++;
					}
					// assign value and find next
					else {
						nums[index] = nums[guard];
						guard++;
						index++;
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		new MoveZeroes().moveZeroes(nums);
		System.out.println(Arrays.toString(nums));;
	}
}
