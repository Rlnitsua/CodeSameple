package lizbyu.bit;

public class TotalHammingDistance {
	public int totalHammingDistance1(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				res += calculateHammingDistance(nums[i], nums[j]);
			}
		}
		return res;
	}

	private int calculateHammingDistance(int num1, int num2) {
		if (num1 == num2) {
			return 0;
		}
		return Integer.bitCount(num1 ^ num2);
	}

	public int totalHammingDistance(int[] nums) {
		int totalDistance = 0;
		for(int i = 0; i < 32; i++){
			int bitCount = 0;
			for(int j = 0; j < nums.length; j++){
				bitCount += (nums[j] >> i) & 1;
			}
			totalDistance += bitCount * (nums.length - bitCount);
		}
		return totalDistance;
	}

}
