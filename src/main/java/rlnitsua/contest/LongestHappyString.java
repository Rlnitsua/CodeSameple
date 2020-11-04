package rlnitsua.contest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> info = initInfo(a, b, c);
        return getString('0', info);
    }

    private String getString(char exclude, Map<Character, Integer> info) {
        StringBuilder res = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : info.entrySet()) {
            if (entry.getKey() == exclude) {
                continue;
            }
            if (entry.getValue() >= 2) {
                if (!isBigest(info.values(), entry.getValue())) {
                    continue;
                }
                res.append(entry.getKey());
                res.append(entry.getKey());
                info.put(entry.getKey(), entry.getValue() - 2);
                res.append(getString(entry.getKey(), info));
                return new String(res);
            }
        }

        for (Map.Entry<Character, Integer> entry : info.entrySet()) {
            if (entry.getKey() == exclude) {
                continue;
            }
            if (entry.getValue() >= 1) {
                res.append(entry.getKey());
                info.put(entry.getKey(), entry.getValue() - 1);
                res.append(getString(entry.getKey(), info));
                return new String(res);
            }
        }

        return new String(res);
    }

    private boolean isBigest(Collection<Integer> entrySet, Integer val) {
        for (Integer num : entrySet) {
            if (num > val) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> initInfo(int a, int b, int c) {
        Map<Character, Integer> info = new HashMap<>();
        info.put('a', a);
        info.put('b', b);
        info.put('c', c);
        return info;
    }
}
