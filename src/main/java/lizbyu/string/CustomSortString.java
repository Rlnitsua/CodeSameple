package lizbyu.string;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String S, String T) {
        boolean[] sExist = countExist(S);
        boolean[] tExist = countExist(T);
        Map<Character, Integer> map = calculateMap(T);

        StringBuffer res = new StringBuffer();

        for (char ch : S.toCharArray()) {
            if (tExist[ch]) {
                appendRes(map, res, ch);
            }
        }

        for (char ch : T.toCharArray()) {
            if (!sExist[ch]) {
                res.append(ch);
            }
        }

        return res.toString();
    }

    private void appendRes(Map<Character, Integer> map, StringBuffer res, char ch) {
        for (int i = 0; i < map.get(ch); i++) {
            res.append(ch);
        }
    }

    private boolean[] countExist(String s) {
        boolean[] exist = new boolean[126];
        for (char ch : s.toCharArray()) {
            exist[ch] = true;
        }
        return exist;
    }

    private Map<Character, Integer> calculateMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }
}
