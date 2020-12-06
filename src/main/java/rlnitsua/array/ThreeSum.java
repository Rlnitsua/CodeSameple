package rlnitsua.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> twoSumList = getTwoSum(nums, i + 1, i + 1, nums.length - 1, nums[i] * (-1));
                for (List<Integer> list : twoSumList) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.addAll(list);
                    res.add(item);
                }
            }
        }

        return res;
    }

    private List<List<Integer>> getTwoSum (int[] nums, int start, int left, int right, int target) {
        List<List<Integer>> list = new ArrayList<>();

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                left++;
            } else if (nums[left] + nums[right] < target) {
                right--;
            } else {
                if (left == start || nums[left] != nums[left - 1]) {
                    List<Integer> sum = new ArrayList<>();
                    sum.add(nums[left]);
                    sum.add(nums[right]);
                    list.add(sum);
                }
                left++;
                right--;
            }
        }
        return list;
    }
}
