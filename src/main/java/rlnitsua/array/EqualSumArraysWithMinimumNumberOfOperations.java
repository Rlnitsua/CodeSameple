package rlnitsua.array;

import java.util.List;

public class EqualSumArraysWithMinimumNumberOfOperations {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                res++;
            }
        }

        return res;
    }
}
