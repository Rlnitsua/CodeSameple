package lizbyu.contest;

public class NumberofSubstringsWithOnly1s {

    public int numSub(String s) {
        int res = 0;
        boolean isContinue1 = false;
        int continue1Len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && isContinue1) {
                res += ((continue1Len * (continue1Len + 1)) / 2) % 1000000007;
                isContinue1 = false;
                continue1Len = 0;
            } else if (s.charAt(i) == '1') {
                isContinue1 = true;
                continue1Len++;
            }

            if (i == s.length() - 1 && isContinue1) {
                res += ((continue1Len * (continue1Len + 1)) / 2) % 1000000007;
            }
        }

        return res;
    }
}
