package lizbyu.contest;

public class HowManyNumbersAreSmallerThantheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int num : nums) {
                if (num < nums[i]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
