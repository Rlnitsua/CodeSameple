package rlnitsua.string;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int valid = 0;

        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        while (right < s2.length()) {
            char rightCh = s2.charAt(right++);
            if (need.containsKey(rightCh)) {
                window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);
                if (window.get(rightCh).equals(need.get(rightCh))) {
                    valid++;
                }
            }

            while (right - left == s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char leftCh = s2.charAt(left++);
                if (need.containsKey(leftCh)) {
                    if (window.get(leftCh).equals(need.get(leftCh))) {
                        valid--;
                    }
                    window.put(leftCh, window.getOrDefault(leftCh, 0) - 1);
                }
            }
        }
        return false;
    }
}
