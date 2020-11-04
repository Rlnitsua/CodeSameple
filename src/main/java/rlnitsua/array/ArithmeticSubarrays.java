package rlnitsua.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// todo: cache
public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            if (r[i] - l[i] < 2) {
                res.add(true);
                continue;
            }

            if (checkArithmeticSubarrays(nums, l[i], r[i])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    private boolean checkArithmeticSubarrays(int[] nums, int l, int r) {
        int[] partNums = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(partNums);
        int diff = partNums[1] - partNums[0];
        for (int j = 0; j < partNums.length - 1; j++) {
            if (partNums[j + 1] - partNums[j] != diff) {
                return false;
            }
        }
        return true;
    }
}
