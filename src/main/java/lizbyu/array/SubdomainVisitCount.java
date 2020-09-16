package lizbyu.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = getMap(cpdomains);
        List<String> res = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }

        return res;
    }

    private Map<String, Integer> getMap(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] cpdomainArr = cpdomain.split(" ");
            int count = Integer.parseInt(cpdomainArr[0]);
            String[] subArr = cpdomainArr[1].split("\\.");

            StringBuilder last = null;
            for (int i = subArr.length - 1; i >= 0; i--) {
                if (last == null) {
                    last = new StringBuilder(subArr[i]);
                } else {
                    last.insert(0, subArr[i] + ".");
                }
                String key = String.valueOf(last);
                if (!map.containsKey(key)) {
                    map.put(key, count);
                } else {
                    map.put(key, map.get(key) + count);
                }
            }
        }
        return map;
    }
}
