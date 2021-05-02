package rlnitsua.contest;

public class ShiftChar {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        char ch = '.';

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                ch = s.charAt(i);
                sb.append(ch);
            } else {
                sb.append(shift(ch, Integer.valueOf(s.charAt(i) + "")));
            }
        }

        return sb.toString();
    }

    private char shift(char ch, int len) {
        return (char)(ch + len);
    }
}
