package rlnitsua.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;

        while (slow < s.length()) {
            if (fast == s.length()) {
                break;
            }

            char target = s.charAt(fast);
            if (!set.contains(target)) {
                fast++;
                set.add(target);
                longest = Math.max(longest, set.size());
            } else {
                set.remove(s.charAt(slow));
                slow++;
            }
        }

        return longest;
    }
}
