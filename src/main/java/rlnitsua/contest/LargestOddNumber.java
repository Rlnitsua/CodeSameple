package rlnitsua.contest;

public class LargestOddNumber {
    public String largestOddNumber(String num) {
        int index = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Integer.parseInt(num.substring(i, i + 1)) % 2 != 0) {
                index = i;
                break;
            }
        }
        return index == -1 ? "" : num.substring(0, index + 1);
    }
}
