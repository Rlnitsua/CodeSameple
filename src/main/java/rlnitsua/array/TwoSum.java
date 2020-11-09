package rlnitsua.array;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("error numbers input !");
    }
}
