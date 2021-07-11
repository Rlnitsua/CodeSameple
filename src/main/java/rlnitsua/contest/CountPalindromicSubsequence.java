package rlnitsua.contest;

import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        int[][] info = new int[26][2];
        for (int i = 0; i < 26; i++) {
            info[i][0] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (info[ch - 'a'][0] == -1) {
                info[ch - 'a'][0] = i;
            }
            info[ch - 'a'][1] = i;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < info.length; i++) {
            int start = info[i][0];
            int end = info[i][1];
            if (start != -1 && start != end) {
                for (int j = start + 1; j < end; j++) {
                    String sb =
                            String.valueOf((char) (i + 'a')) +
                            s.charAt(j) +
                            (char) (i + 'a');
                    set.add(sb);
                }
            }
        }
        return set.size();
    }
}
