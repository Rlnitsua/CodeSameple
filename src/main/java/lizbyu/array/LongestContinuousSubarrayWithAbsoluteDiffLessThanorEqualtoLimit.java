package lizbyu.array;

import javafx.collections.transformation.SortedList;

import java.util.List;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int longest = 0;
        int lo = 0;
        int hi = 0;
        int max = nums[0];
        int min = nums[0];

        while (hi < nums.length) {
            if (max - min > limit) {
                if (nums[lo] == max) {
                    int tempMax = min;
                    for (int i = lo + 1; i <= hi; i++) {
                        tempMax = Math.max(tempMax, nums[i]);
                    }
                    max = tempMax;
                } else if (nums[lo] == min) {
                    int tempMin = max;
                    for (int i = lo + 1; i <= hi; i++) {
                        tempMin = Math.min(tempMin, nums[i]);
                    }
                    min = tempMin;
                }
                lo++;
                longest--;
                continue;
            }

            if (nums[hi] >= min && nums[hi] <= max) {
                longest++;
                hi++;
            } else if (nums[hi] < min) {
                min = nums[hi];
                if (max - min <= limit) {
                    longest++;
                    hi++;
                } else {
                    if (nums[lo] == max) {
                        int tempMax = min;
                        for (int i = lo + 1; i <= hi; i++) {
                            tempMax = Math.max(tempMax, nums[i]);
                        }
                        max = tempMax;
                    }
                    lo++;
                    longest--;
                }
            } else {
                max = nums[hi];
                if (max - min <= limit) {
                    longest++;
                    hi++;
                } else {
                    if (nums[lo] == min) {
                        int tempMin = max;
                        for (int i = lo + 1; i <= hi; i++) {
                            tempMin = Math.min(tempMin, nums[i]);
                        }
                        min = tempMin;
                    }
                    lo++;
                    longest--;
                }
            }
            res = Math.max(res, longest);
        }

        return res;
    }
}
