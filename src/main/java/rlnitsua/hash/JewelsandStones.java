package rlnitsua.hash;

import java.util.HashMap;
import java.util.Map;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int nums = 0;

        Map<Character, Integer> info = getInfo(S);

        for (char ch : info.keySet()) {
            for (char jCh : J.toCharArray()) {
                if (ch == jCh) {
                    nums += info.get(ch);
                    break;
                }
            }
        }
        return nums;
    }

    private Map<Character, Integer> getInfo(String s) {
        Map<Character, Integer> info = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (info.containsKey(ch)) {
                info.put(ch, info.get(ch) + 1);
            } else {
                info.put(ch, 1);
            }
        }

        return info;
    }
}
