package lizbyu.string;

public class FivePalindrome {
    public int Fivecharacterpalindrome(String s) {
        if (s.isEmpty() || s.length() < 5) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i <= s.length() - 5; i++) {
            if (s.charAt(i) != s.charAt(i + 1)
                && s.charAt(i + 1) != s.charAt(i + 2)
                && s.charAt(i) != s.charAt(i + 2)) {
                if (s.charAt(i) == s.charAt(i + 4)
                        && s.charAt(i + 1) == s.charAt(i + 3)) {
                    res++;
                }
            }
        }
        return res;
    }
}
