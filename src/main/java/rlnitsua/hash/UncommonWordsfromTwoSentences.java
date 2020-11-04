package rlnitsua.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> aInfo = getSet(A);
        Map<String, Integer> bInfo = getSet(B);

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : aInfo.entrySet()) {
            if (entry.getValue() == 1 && !bInfo.containsKey(entry.getKey())) {
                res.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : bInfo.entrySet()) {
            if (entry.getValue() == 1 && !aInfo.containsKey(entry.getKey())) {
                res.add(entry.getKey());
            }
        }

        return res.toArray(new String[0]);
    }

    private Map<String, Integer> getSet(String a) {
        Map<String, Integer> info = new HashMap<>();
        for (String word : a.split(" ")) {
            if (info.containsKey(word)) {
                info.put(word, info.get(word) + 1);
            } else {
                info.put(word, 1);
            }
        }
        return info;
    }
}
