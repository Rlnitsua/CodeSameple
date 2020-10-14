package lizbyu.array;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ContainsDuplicateII {
    private static final String TAG = "ContainsDuplicateII";

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                map.get(nums[i]).add(i);
            }
        }

        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size() - 1; i++) {
                if (entry.getValue().get(i + 1) - entry.getValue().get(i) <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 7};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new ContainsDuplicateII().containsNearbyDuplicate(nums, 3));
    }
}
