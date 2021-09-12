package rlnitsua.array;

import java.util.Arrays;

public class CanConvertString {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int target = t.charAt(i);
            int origin = s.charAt(i);
            times[target >= origin ? target - origin : target - origin + 26]++;
        }

        int[] resources = new int[26];
        Arrays.fill(resources, k / 26);
        for (int i = 0; i <= (k % 26); i++) {
            resources[i]++;
        }

        for (int i = 1; i < 26; i++) {
            if (resources[i] < times[i]) {
                return false;
            }
        }
        return true;
    }
}
