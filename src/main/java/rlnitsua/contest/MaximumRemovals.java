package rlnitsua.contest;

import java.util.HashSet;
import java.util.Set;

public class MaximumRemovals {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = -1;
        int r = removable.length;

        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            if (judge(s, p, removable, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l + 1;
    }

    private boolean judge(String s, String p, int[] removable, int index) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= index; i++) {
            set.add(removable[i]);
        }

        int sStart = 0;
        int pStart = 0;

        while (sStart < s.length() && pStart < p.length()) {
            if (set.contains(sStart)) {
                sStart++;
                continue;
            }
            if (s.charAt(sStart) == p.charAt(pStart)) {
                pStart++;
            }
            sStart++;
        }
        return pStart == p.length();
    }
}
