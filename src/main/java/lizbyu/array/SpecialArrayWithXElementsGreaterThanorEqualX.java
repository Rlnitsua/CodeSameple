package lizbyu.array;

public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public int specialArray(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int count = getCount(nums, i);
            if (i == count) {
                return i;
            } else if (i > count) {
                return -1;
            }
        }
        return 0;
    }

    private int getCount(int[] nums, int i) {
        int count = 0;
        for (int num : nums) {
            if (num >= i) {
                count++;
            }
        }
        return count;
    }
}
