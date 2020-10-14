package lizbyu.hash;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindAllAnagramsinaString {
    private static final String TAG = "FindAllAnagramsinaString";

    public List<Integer> findAnagrams0(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0) {
            return list;
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (isAnagram(s.substring(i, i + p.length()), p)) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;
        for (char c : p.toCharArray())
            chars[c - 'a']++;

        int start = 0, end = 0, count = p.length();
        // Go over the string
        while (end < s.length()) {
            // If the char at start appeared in p, we increase count
            if (end - start == p.length()
                    && chars[s.charAt(start++) - 'a']++ >= 0)
                count++;
            // If the char at end appeared in p (since it's not -1 after
            // decreasing), we decrease count
            if (--chars[s.charAt(end++) - 'a'] >= 0)
                count--;
            if (count == 0)
                result.add(start);
        }

        return result;
    }

    private boolean isAnagram(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : p.toCharArray()) {
            int chCount = map.get(ch) == null ? 0 : map.get(ch);
            map.put(ch, chCount + 1);
        }
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == null) {
                return false;
            } else {
                int chCount = map.get(ch) == null ? 0 : map.get(ch);
                map.put(ch, chCount - 1);
            }
        }
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG,
                new FindAllAnagramsinaString().findAnagrams("abab", "ab"));
        LogUtils.d(TAG, new FindAllAnagramsinaString().findAnagrams(
                "cbaebabacd", "abc"));
    }
}
