package rlnitsua.contest;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {
    public String reformat(String s) {
        List<Character> lowercaseCharArray = new ArrayList<>();
        List<Character> digitCharArray = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (ch >= 97 && ch <= 122) {
                lowercaseCharArray.add(ch);
            } else if (ch >= 48 && ch <= 57) {
                digitCharArray.add(ch);
            }
        }

        if (Math.abs(lowercaseCharArray.size() - digitCharArray.size()) > 1) {
            return "";
        }

        String res;
        if (lowercaseCharArray.size() >= digitCharArray.size()) {
            res = formatString(lowercaseCharArray, digitCharArray);
        } else {
            res = formatString(digitCharArray, lowercaseCharArray);
        }


        return res;
    }

    private String formatString(List<Character> first, List<Character> second) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < first.size(); i++) {
            sb.append(first.get(i));
            if (i < second.size()) {
                sb.append(second.get(i));
            }
        }

        return sb.toString();
    }
}
