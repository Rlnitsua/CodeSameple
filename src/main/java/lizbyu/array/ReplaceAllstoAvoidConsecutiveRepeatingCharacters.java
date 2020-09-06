package lizbyu.array;

public class ReplaceAllstoAvoidConsecutiveRepeatingCharacters {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            if (chars[0] == '?') {
                return "a";
            } else {
                return s;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                if (i == 0) {
                    if (chars[i + 1] == '?') {
                        chars[i] = 'a';
                    } else {
                        chars[i] = getChar(chars[i + 1]);
                    }
                } else if (i == s.length() - 1) {
                    chars[i] = getChar(chars[i - 1]);
                } else {
                    if (chars[i + 1] == '?') {
                        chars[i] = getChar(chars[i - 1]);
                    } else {
                        chars[i] = getChar(chars[i - 1], chars[i + 1]);
                    }
                }
            }
        }
        return new String(chars);
    }

    private char getChar(char... chars) {
        int target = 97;

        while (true) {
            boolean contains = false;
            for (char ch : chars) {
                if (ch == target) {
                    if (target != 122) {
                        target++;
                    } else {
                        target = 97;
                    }
                    contains = true;
                    break;
                }
            }

            if (!contains) {
                return (char)target;
            }
        }
    }
}
