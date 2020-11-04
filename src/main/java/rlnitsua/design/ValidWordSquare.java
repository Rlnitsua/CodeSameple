package rlnitsua.design;

import rlnitsua.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidWordSquare {
    private static final String TAG = "ValidWordSquare";

    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (words.size() < (j + 1) ||
                        words.get(j).length() < (i + 1) ||
                        words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("abcd1");
        words.add("bnrt");
        words.add("crmy");
        words.add("dtye1");
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new ValidWordSquare().validWordSquare(words));

        String[] wors1Array = {"ball", "asee", "let", "lep"};
        List<String> words1 = Arrays.asList(wors1Array);
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new ValidWordSquare().validWordSquare(words1));
    }
}
