package lizbyu.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineStockSpan {
    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();

    public int next(int price) {
        list.add(price);
        int index = list.size() - 2;
        int span = 1;

        while (index >= 0) {
            if (price >= list.get(index)) {
                span += map.get(index);
                index -= map.get(index);
            } else {
                break;
            }
        }

        map.put(list.size() - 1, span);
        return span;
    }
}
