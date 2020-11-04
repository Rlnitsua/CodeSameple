package rlnitsua.dynamic;

public class MinimumASCIIDeleteSumforTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int res = 0;
        int s2CurrentIndex = 0;
        for (char ch1 : s1.toCharArray()) {
            if (containCh1(s2, ch1, s2CurrentIndex)) {
                int s2NextIndex = getCh1Position(s2, ch1, s2CurrentIndex);
                for (int i = s2CurrentIndex + 1; i < s2NextIndex; i++) {
                    res += s2.indexOf(i);
                }
                s2CurrentIndex = s2NextIndex;
            } else {
                res += ch1;
            }
        }

        for (int i = s2CurrentIndex + 1; i < s2.length(); i++) {
            res += s2.indexOf(i);
        }
        return res;
    }

    private boolean containCh1(String s2, char ch1, int s2CurrentIndex) {
        return false;
    }

    private int getCh1Position(String s2, char ch1, int s2CurrentIndex) {
        return 0;
    }
}
