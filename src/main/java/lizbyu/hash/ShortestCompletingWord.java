package lizbyu.hash;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> info = staticInfo(licensePlate);
        int totalNum = getTotalNum(info);
        String res = "";
        int minLen = Integer.MAX_VALUE;
        for (String word : words) {
            if (isValidWord(info, word, totalNum)) {
                if (word.length() < minLen) {
                    res = word;
                    minLen = res.length();
                }
            }
        }
        return res;
    }

    private Map<Character, Integer> staticInfo(String licensePlate) {
        Map<Character, Integer> info = new HashMap<>();
        for (char ch : licensePlate.toCharArray()) {
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                char targetCh = (ch <= 90) ? (char) (ch + 32) : ch;
                if (info.containsKey(targetCh)) {
                    info.put(targetCh, info.get(targetCh) + 1);
                } else {
                    info.put(targetCh, 1);
                }
            }
        }
        return info;
    }

    private int getTotalNum(Map<Character, Integer> info) {
        int count = 0;
        for (Integer i : info.values()) {
            count += i;
        }
        return count;
    }

    private boolean isValidWord(Map<Character, Integer> info, String word, int totalNum) {
        Map<Character, Integer> selfInfo = new HashMap<>();
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (info.containsKey(ch)) {
                if (selfInfo.containsKey(ch)) {
                    if (selfInfo.get(ch) < info.get(ch)) {
                        count++;
                    }
                    selfInfo.put(ch, selfInfo.get(ch) + 1);
                } else {
                    selfInfo.put(ch, 1);
                    count++;
                }

                if (count == totalNum) {
                    return true;
                }
            }
        }
        return false;
    }
}
