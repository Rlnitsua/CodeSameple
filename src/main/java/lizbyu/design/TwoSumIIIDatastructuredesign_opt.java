package lizbyu.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIIIDatastructuredesign_opt {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIIIDatastructuredesign_opt() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
            list.add(number);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int otherNumber = value - num;

            if ((num == otherNumber && map.get(num) > 1) ||
                    (num != otherNumber && map.containsKey(otherNumber))) {
                return true;
            }
        }

        return false;
    }
}
