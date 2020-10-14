package lizbyu.math;

import lizbyu.utils.log.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConvertaNumbertoHexadecimal {
    private static final String TAG = "ConvertaNumbertoHexadecimal";

    public String toHex(int num) {
        Map<Long, Character> chMap = initChMap();
        Map<Character, Long> peggingMap = initPeggingMap();

        String hexStr = null;
        if (num > 0) {
            hexStr = getPositiveHex(num, chMap);
        } else if (num < 0) {
            hexStr = getPositiveHex(Math.abs((long) num), chMap);
            hexStr = changeToNagetive(hexStr, chMap, peggingMap);
            hexStr = addOne(hexStr, chMap, peggingMap);
        } else {
            hexStr = "0";
        }
        return hexStr;
    }

    private Map<Long, Character> initChMap() {
        Map<Long, Character> chMap = new HashMap<Long, Character>();
        chMap.put((long) 0, '0');
        chMap.put((long) 1, '1');
        chMap.put((long) 2, '2');
        chMap.put((long) 3, '3');
        chMap.put((long) 4, '4');
        chMap.put((long) 5, '5');
        chMap.put((long) 6, '6');
        chMap.put((long) 7, '7');
        chMap.put((long) 8, '8');
        chMap.put((long) 9, '9');
        chMap.put((long) 10, 'a');
        chMap.put((long) 11, 'b');
        chMap.put((long) 12, 'c');
        chMap.put((long) 13, 'd');
        chMap.put((long) 14, 'e');
        chMap.put((long) 15, 'f');
        return chMap;
    }

    private Map<Character, Long> initPeggingMap() {
        Map<Character, Long> pegginMap = new HashMap<Character, Long>();
        pegginMap.put('0', (long) 0);
        pegginMap.put('1', (long) 1);
        pegginMap.put('2', (long) 2);
        pegginMap.put('3', (long) 3);
        pegginMap.put('4', (long) 4);
        pegginMap.put('5', (long) 5);
        pegginMap.put('6', (long) 6);
        pegginMap.put('7', (long) 7);
        pegginMap.put('8', (long) 8);
        pegginMap.put('9', (long) 9);
        pegginMap.put('a', (long) 10);
        pegginMap.put('b', (long) 11);
        pegginMap.put('c', (long) 12);
        pegginMap.put('d', (long) 13);
        pegginMap.put('e', (long) 14);
        pegginMap.put('f', (long) 15);
        return pegginMap;
    }

    private String getPositiveHex(long number, Map<Long, Character> chMap) {
        Stack<Character> stack = new Stack<Character>();
        while (number >= 1) {
            stack.push(chMap.get(number % 16));
            number /= 16;
        }
        StringBuffer sb = new StringBuffer();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return new String(sb);
    }

    private String changeToNagetive(String hexStr, Map<Long, Character> chMap, Map<Character, Long> peggingMap) {
        int strLength = hexStr.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < (8 - strLength); i++) {
            sb.append('0');
        }
        sb.append(hexStr);

        char[] chArray = sb.toString().toCharArray();

        for (int i = 0; i < sb.length(); i++) {
            chArray[i] = chMap.get(15 - peggingMap.get(chArray[i]));
        }

        return new String(chArray);
    }

    private String addOne(String hexStr, Map<Long, Character> chMap, Map<Character, Long> peggingMap) {
        char[] chArray = hexStr.toCharArray();
        for (int i = (chArray.length - 1); i >= 0; i--) {
            if (chArray[i] == 'f') {
                chArray[i] = '0';
            } else {
                chArray[i] = chMap.get((peggingMap.get(chArray[i]) + 1));
                break;
            }
        }
        return new String(chArray);
    }

    public static void main(String[] args) {
//		LogUtils.d(TAG, (int)'a');
//		LogUtils.d(TAG, (int)'1');
//		LogUtils.d(TAG, (char)1);
//		LogUtils.d(TAG, (char)49);
//		LogUtils.d(TAG, (int)'d' - (int)'3');
//		LogUtils.d(TAG, (char)(10+38));
//		LogUtils.d(TAG, (char)(13+38));
        LogUtils.d(TAG, (char) (5 + 48));
        LogUtils.d(TAG, "start");
//		LogUtils.d(TAG, new ConvertaNumbertoHexadecimal().toHex(5613));
//		LogUtils.d(TAG, new ConvertaNumbertoHexadecimal().toHex(0));
//		LogUtils.d(TAG, new ConvertaNumbertoHexadecimal().toHex(-1));
//		LogUtils.d(TAG, new ConvertaNumbertoHexadecimal().toHex(-5613));
        LogUtils.d(TAG, Math.abs(-2147483648));
        LogUtils.d(TAG, new ConvertaNumbertoHexadecimal().toHex(-2147483648));
    }
}
