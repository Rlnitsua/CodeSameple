package lizbyu.contest;

public class CreateTargetArrayintheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currentNums = nums[i];
            int currentIndex = index[i];

            if (currentIndex < i) {
                System.arraycopy(res, currentIndex, res, currentIndex + 1, i - currentIndex);
            }

            res[currentIndex] = currentNums;
        }

        return res;
    }
}
