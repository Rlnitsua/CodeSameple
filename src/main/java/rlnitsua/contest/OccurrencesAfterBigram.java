package rlnitsua.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] textArr = text.split(" ");
        findFromCurrentWord(0, textArr, first, second, res);
        return res.toArray(new String[res.size()]);
    }

    private void findFromCurrentWord(int index, String[] textArr, String first, String second, List<String> res) {
        if (index >= textArr.length - 2) {
            return;
        }

        if (textArr[index].equals(first)) {
            if (textArr[index + 1].equals(second)) {
                if (index + 2 <= textArr.length - 1) {
                    res.add(textArr[index + 2]);
                }
                findFromCurrentWord(index + 2, textArr, first, second, res);
            } else {
                findFromCurrentWord(index + 1, textArr, first, second, res);
            }
        } else {
            findFromCurrentWord(index + 1, textArr, first, second, res);
        }
    }

    public static void main(String[] args) {
        OccurrencesAfterBigram oab = new OccurrencesAfterBigram();
        String text0 = "we will we will rock you";
        String first = "we";
        String second = "will";
        String[] findOcurrences = oab.findOcurrences(text0, first, second);
        System.out.println(new ArrayList<String>(Arrays.asList(findOcurrences)));

    }
}
