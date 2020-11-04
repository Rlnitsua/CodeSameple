package rlnitsua.hash;

import rlnitsua.utils.log.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IsomorphicStrings {
    private static final String TAG = "IsomorphicStrings";

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();

        if (s == null && t == null) {
            return true;
        } else if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null) {
                    for (Entry<Character, Character> entry : map.entrySet()) {
                        if (entry.getValue() == t.charAt(i)) {
                            return false;
                        }
                    }
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    if (map.get(s.charAt(i)) != t.charAt(i)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new IsomorphicStrings().isIsomorphic("aa", "ab"));
        LogUtils.d(TAG, new IsomorphicStrings().isIsomorphic("ab", "aa"));
        LogUtils.d(TAG, new IsomorphicStrings().isIsomorphic("egg", "add"));
        LogUtils.d(TAG, new IsomorphicStrings().isIsomorphic("foo", "bar"));
        LogUtils.d(TAG, new IsomorphicStrings().isIsomorphic("paper", "title"));
    }
}
