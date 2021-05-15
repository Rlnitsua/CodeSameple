package rlnitsua.contest;

import java.util.Map;
import java.util.TreeMap;

public class SortSentence {
    public String sortSentence(String s) {
        String[] wordArr = s.split(" ");
        Map<Integer, String> map = new TreeMap<>();
        for (String word : wordArr) {
            int num = Integer.parseInt(word.charAt(word.length() - 1) + "");
            map.put(num, word.substring(0, word.length() - 1));
        }
        StringBuilder sb = new StringBuilder();
        for (String word : map.values()) {
            sb.append(word).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
