package rlnitsua.contest;

import rlnitsua.utils.log.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumNumberofBalloons {
    private static final String TAG = "MaximumNumberofBalloons";

    public int maxNumberOfBalloons(String text) {
        char[] chArray = text.toCharArray();

        Map<Character, Integer> data = new HashMap<>();
        data.put('b', 0);
        data.put('a', 0);
        data.put('n', 0);
        data.put('l', 0);
        data.put('o', 0);
        for (char ch : chArray) {
            if (data.containsKey(ch)) {
                data.put(ch, data.get(ch) + 1);
            } else {
                data.put(ch, 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (Entry<Character, Integer> entry : data.entrySet()) {
            if (entry.getKey() == 'b' || entry.getKey() == 'a'
                    || entry.getKey() == 'n') {
                res = Math.min(res, entry.getValue());
            } else if (entry.getKey() == 'l' || entry.getKey() == 'o') {
                res = Math.min(res, entry.getValue() / 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumNumberofBalloons balloons = new MaximumNumberofBalloons();
        LogUtils.d(TAG, balloons.maxNumberOfBalloons("nlaebolko"));
        LogUtils.d(TAG, balloons.maxNumberOfBalloons("loonbalxballpoon"));
        LogUtils.d(TAG, balloons.maxNumberOfBalloons("leetcode"));
        LogUtils.d(TAG, balloons.maxNumberOfBalloons("lloo"));
    }
}
