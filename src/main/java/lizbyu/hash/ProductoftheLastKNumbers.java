package lizbyu.hash;

import java.util.HashMap;
import java.util.Map;

public class ProductoftheLastKNumbers {
    private final Map<Integer, Integer> info;
    private int lastZero;
    private int count;

    public ProductoftheLastKNumbers() {
        info = new HashMap<>();
    }

    public void add(int num) {
        count++;
        if (num == 0) {
            lastZero = count;
            info.clear();
        } else {
            info.put(info.size() + 1, info.getOrDefault(info.size(), 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k > count - lastZero) {
            return 0;
        } else {
            return info.get(info.size()) / info.getOrDefault(info.size() - k, 1);
        }
    }
}
