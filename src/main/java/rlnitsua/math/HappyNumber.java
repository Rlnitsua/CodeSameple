package rlnitsua.math;

import rlnitsua.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// Error method
@Deprecated
public class HappyNumber {
    private static final String TAG = "HappyNumber";

    public boolean isHappy(int n) {
        Map<Integer, Boolean> happyNumberMap = new HashMap<Integer, Boolean>();
        happyNumberMap.put(1, false);
        happyNumberMap.put(10, false);
        happyNumberMap.put(100, false);
        return happyNumberMap.containsKey(n);
    }

    //Error code
    @Deprecated
    private List<Integer> getAllHappyName(Map<Integer, Boolean> happyNumberMap) {
        int beginCount = happyNumberMap.size();
        List<Integer> happyNumList = new ArrayList<Integer>();
        for (Entry<Integer, Boolean> entry : happyNumberMap.entrySet()) {
            if (!entry.getValue()) {
                happyNumList.add(entry.getKey());
            }
        }
        for (int num : happyNumList) {
            for (int n = 0; n < 10; n++) {
                for (int m = 0; m < 10; m++) {
                    if (n * n + m * m == num) {
                        happyNumberMap.put(n + m * 10, false);
                    }
                }
            }
            happyNumberMap.put(num, true);
        }

        if (beginCount == happyNumberMap.size()) {
            happyNumList.clear();
            for (int happyNumber : happyNumberMap.keySet()) {
                happyNumList.add(happyNumber);
            }
            happyNumList.remove((Integer) 100);
            return happyNumList;
        } else {
            return getAllHappyName(happyNumberMap);
        }
    }

    public static void main(String[] args) {
        Map<Integer, Boolean> happyNumberMap = new HashMap<Integer, Boolean>();
        happyNumberMap.put(1, false);
        happyNumberMap.put(10, false);
        happyNumberMap.put(100, false);
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new HappyNumber().getAllHappyName(happyNumberMap));
    }
}
