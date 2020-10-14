package lizbyu.contest;

import lizbyu.utils.log.LogUtils;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedbyCharacters {
    private static final String TAG = "FindWordsThatCanBeFormedbyCharacters";

    public int countCharacters(String[] words, String chars) {
        int res = 0;
        Map<Character, Integer> source = getFromChars(chars);
        for (String word : words) {
            if (isGoodString(word, source)) {
                res += word.length();
            }
        }
        return res;
    }

    private Map<Character, Integer> getFromChars(String chars) {
        Map<Character, Integer> source = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            if (source.containsKey(ch)) {
                source.put(ch, source.get(ch) + 1);
            } else {
                source.put(ch, 1);
            }
        }
        return source;
    }

    private boolean isGoodString(String word, Map<Character, Integer> source) {
        Map<Character, Integer> currentSource = new HashMap<>(source);
        for (char ch : word.toCharArray()) {
            if (currentSource.containsKey(ch)) {
                currentSource.put(ch, currentSource.get(ch) - 1);
            } else {
                return false;
            }
            if (currentSource.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindWordsThatCanBeFormedbyCharacters demo = new FindWordsThatCanBeFormedbyCharacters();
        LogUtils.d(TAG, demo.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        LogUtils.d(TAG, demo.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
