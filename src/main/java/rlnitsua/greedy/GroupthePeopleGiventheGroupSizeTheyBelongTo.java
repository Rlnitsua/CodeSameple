package rlnitsua.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 1) {
                List<Integer> group = new ArrayList<>();
                group.add(i);
                res.add(group);
                continue;
            }

            if (map.containsKey(groupSizes[i])) {
                if (map.get(groupSizes[i]).size() == groupSizes[i] - 1) {
                    map.get(groupSizes[i]).add(i);
                    res.add(map.get(groupSizes[i]));
                    map.remove(groupSizes[i]);
                } else {
                    map.get(groupSizes[i]).add(i);
                }
            } else {
                List<Integer> group = new ArrayList<>();
                group.add(i);
                map.put(groupSizes[i], group);
            }
        }

        return res;
    }
}
