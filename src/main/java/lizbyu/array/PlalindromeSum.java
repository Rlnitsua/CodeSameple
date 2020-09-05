package lizbyu.array;

public class PlalindromeSum {
    public long suffixQuery(String s) {
        long res = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                res += num(s.substring(j, j + i));
            }
        }
        return res;
    }

    private int num(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int num = 0;
        for (int i = 0; i < (s.length() / 2) - 1; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                num++;
            } else {
                break;
            }
        }
        return num;
    }
}
