package rlnitsua.contest;

public class IsSumEqual {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return num(firstWord) + num(secondWord) == num(targetWord);
    }

    private int num(String word) {
        int num = 0;

        int e = 0;
        for (int i = word.length() - 1; i >= 0; i--) {
            num += (word.charAt(i) - 'a') * Math.pow(10, e++);
        }
        return num;
    }
}
