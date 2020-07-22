package lizbyu.array;

public class ShuffletheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int first = 0;
        int second = n;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[first++];
            } else {
                res[i] = nums[second++];
            }
        }
        return res;
    }
}
