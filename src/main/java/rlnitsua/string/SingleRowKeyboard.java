package rlnitsua.string;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> keyInfo = calculateKeyInfo(keyboard);

        int step = 0;
        char last = keyboard.charAt(0);
        for (char ch : word.toCharArray()) {
            step += Math.abs(keyInfo.get(ch) - keyInfo.get(last));
            last = ch;
        }
        return step;
    }

    private Map<Character, Integer> calculateKeyInfo(String keyboard) {
        Map<Character, Integer> keyInfo = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            keyInfo.put(keyboard.charAt(i), i);
        }
        return keyInfo;
    }
}
