package rlnitsua.string;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        while (right < s.length()) {
            char rightCh = s.charAt(right++);
            if (need.containsKey(rightCh)) {
                window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);
                if (window.get(rightCh).equals(need.get(rightCh))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char leftCh = s.charAt(left++);
                if (need.containsKey(leftCh)) {
                    if (window.get(leftCh).equals(need.get(leftCh))) {
                        valid--;
                    }
                    window.put(leftCh, window.get(leftCh) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
