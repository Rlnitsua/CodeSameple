package lizbyu.dynamic;


import lizbyu.utils.log.LogUtils;

public class RangeSumQueryImmutable {
    private static final String TAG = "RangeSumQueryImmutable";

    private int[] nums;
    private int lastStart = 0;
    private int lastEnd = 0;
    private int lastSum = 0;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int startIndex = i < 0 ? 0 : i;
        int endIndex = j > nums.length ? nums.length - 1 : j;

        // first calculate
        if (lastStart == 0 && lastEnd == 0 && lastSum == 0) {
            for (int x = startIndex; x <= endIndex; x++) {
                sum += nums[x];
            }
        } else if (lastStart == startIndex && lastEnd == endIndex) {
            sum = lastSum;
        } else {
            // two independent sections
            if (lastEnd <= startIndex || endIndex <= lastStart) {
                for (int x = startIndex; x <= endIndex; x++) {
                    sum += nums[x];
                }
            }
            //contain
            else if (startIndex <= lastStart && endIndex >= lastEnd) {
                sum += lastSum;
                for (int x = startIndex; x < lastStart; x++) {
                    sum += nums[x];
                }
                for (int x = lastEnd + 1; x <= endIndex; x++) {
                    sum += nums[x];
                }
            } else if (lastStart <= startIndex && lastEnd >= endIndex) {
                sum += lastSum;
                for (int x = lastStart; x < startIndex; x++) {
                    sum -= nums[x];
                }
                for (int x = endIndex + 1; x <= lastEnd; x++) {
                    sum -= nums[x];
                }
            }
            // cross
            else if (startIndex <= lastStart && lastStart <= endIndex) {
                sum += lastSum;
                for (int x = startIndex; x < lastStart; x++) {
                    sum -= nums[x];
                }
            } else if (lastStart <= startIndex && startIndex <= lastEnd) {
                sum += lastSum;
                for (int x = lastEnd + 1; x <= endIndex; x++) {
                    sum -= nums[x];
                }
            } else {
                for (int x = startIndex; x <= endIndex; x++) {
                    sum += nums[x];
                }
            }
        }


        //cache result
        lastSum = sum;
        lastStart = startIndex;
        lastEnd = endIndex;

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable instance = new RangeSumQueryImmutable(nums);
        LogUtils.d(TAG, instance.sumRange(0, 2));
        LogUtils.d(TAG, instance.sumRange(2, 5));
        LogUtils.d(TAG, instance.sumRange(0, 5));
    }
}
