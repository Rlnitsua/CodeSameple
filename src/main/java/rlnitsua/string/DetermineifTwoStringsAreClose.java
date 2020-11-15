package rlnitsua.string;

import java.util.HashMap;
import java.util.Map;

public class DetermineifTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> charInfo1 = calculateCharInfo(word1);
        Map<Character, Integer> charInfo2 = calculateCharInfo(word2);

        for (char ch : charInfo1.keySet()) {
            if (!charInfo2.containsKey(ch)) {
                return false;
            }
        }

        Map<Integer, Integer> info1 = calculateInfo(charInfo1);
        Map<Integer, Integer> info2 = calculateInfo(charInfo2);

        for (Map.Entry<Integer, Integer> entry : info1.entrySet()) {
            Integer key = entry.getKey();
            if (!info2.containsKey(key) || !entry.getValue().equals(info2.get(key))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> calculateCharInfo(String word) {
        Map<Character, Integer> charInfo = new HashMap<>();
        for (char ch : word.toCharArray()) {
            charInfo.put(ch, charInfo.getOrDefault(ch, 0) + 1);
        }
        return charInfo;
    }

    private Map<Integer, Integer> calculateInfo(Map<Character, Integer> charInfo) {
        Map<Integer, Integer> info = new HashMap<>();
        for (Integer count : charInfo.values()) {
            info.put(count, info.getOrDefault(count, 0) + 1);
        }
        return info;
    }
}
