package lizbyu.design;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsfromEnglish {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int[] info = new int[10];

        info[0] = map.getOrDefault('z', 0);
        info[2] = map.getOrDefault('w', 0);
        info[4] = map.getOrDefault('u', 0);
        info[6] = map.getOrDefault('x', 0);
        info[8] = map.getOrDefault('g', 0);

        info[1] = map.getOrDefault('o', 0) - info[0] - info[2] - info[4];
        info[3] = map.getOrDefault('h', 0) - info[8];
        info[5] = map.getOrDefault('f', 0) - info[4];
        info[7] = map.getOrDefault('s', 0) - info[6];
        info[9] = map.getOrDefault('i', 0) - info[5] - info[6] - info[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < info[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

}
