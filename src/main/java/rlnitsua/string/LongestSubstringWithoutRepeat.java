package rlnitsua.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int longest = 0;

        while (right < s.length()) {
            char rightCh = s.charAt(right++);
            map.put(rightCh, map.getOrDefault(rightCh, 0) + 1);

            while (map.get(rightCh) > 1) {
                char leftCh = s.charAt(left++);
                map.put(leftCh, map.get(leftCh) - 1);
            }
            longest = Math.max(longest, right - left);
        }

        return longest;
    }
}
