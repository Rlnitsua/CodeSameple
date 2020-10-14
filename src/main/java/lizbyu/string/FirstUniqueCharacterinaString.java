package lizbyu.string;

import lizbyu.utils.log.LogUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueCharacterinaString {
    private static final String TAG = "FirstUniqueCharacterinaString";

    public int firstUniqChar0(String s) {
        char[] chArray = s.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            for (int j = (i + 1); j < chArray.length; j++) {
                if (chArray[i] == chArray[j]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            int chCount = map.get(ch) == null ? 0 : map.get(ch);
            map.put(ch, ++chCount);
        }

        char uniqChar = '0';
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqChar = entry.getKey();
                break;
            }
        }

        return uniqChar == '0' ? -1 : s.indexOf(uniqChar);
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new FirstUniqueCharacterinaString().firstUniqChar(s));
    }
}
