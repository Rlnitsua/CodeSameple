package rlnitsua.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MagicTower {
    public int magicTower(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }

        return magicTower(nums, 0, 1);
    }

    private int magicTower(int[] nums, int startIndex, int moreLife) {
        List<Integer> negativeList = new ArrayList<>();
        int positiveSum = 0;
        int negativeSum = 0;

        boolean isNegative = false;

        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (isNegative) {
                    if (moreLife + positiveSum + negativeSum >= 0) {
                        return magicTower(nums, i, moreLife + positiveSum + negativeSum);
                    }

                    Collections.sort(negativeList);
                    int currNegativeLife = 0;
                    int num = 0;
                    for (Integer negative : negativeList) {
                        currNegativeLife += negative;
                        num++;
                        int life = moreLife + positiveSum + negativeSum - currNegativeLife;
                        if (life >= 0) {
                            return num + magicTower(nums, i, life);
                        }
                    }
                }
                positiveSum += nums[i];
            } else if (nums[i] < 0) {
                isNegative = true;
                negativeList.add(nums[i]);
                negativeSum += nums[i];
            }
        }

        return 0;
    }
}
