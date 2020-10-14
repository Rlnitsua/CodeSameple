package lizbyu.divide;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		boolean exsitReverse = true;
		for (int i = 0; i < k; i++) {
			if (exsitReverse) {
				exsitReverse = false;
				for (int j = 0; j < (nums.length - i - 1); j++) {
					if (nums[j] > nums[j + 1]) {
						exsitReverse = true;
						swap(nums, j, j+1);
					}
				}
			}else {
				break;
			}
		}
		return nums[nums.length - k];
	}

	private void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
//		int[] a = {3, 2, 1, 5, 6, 4};
		int[] b = {6, 1, 2, 3, 4, 5};
		System.out.println(new KthLargest().findKthLargest(b, 2));
	}
}
