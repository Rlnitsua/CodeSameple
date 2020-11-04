package rlnitsua.contest;

import java.util.ArrayList;
import java.util.List;

public class StringMatchinginanArray {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (words[i].length() < words[j].length() && words[j].contains(words[i])) {
                        res.add(words[i]);
                    }
                }
            }
        }

        return res;
    }
}
