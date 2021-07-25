package rlnitsua.contest;

public class GetLucky {
    public int getLucky(String s, int k) {
        String origin = getOrigin(s);
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                res = addString(origin);
            } else {
                res = change(res);
            }
        }
        return res;
    }

    private String getOrigin(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append((ch - 'a' + 1));
        }
        return sb.toString();
    }

    private int addString(String origin) {
        int sum = 0;
        for (int i = 0; i < origin.length(); i++) {
            sum += Integer.parseInt(origin.charAt(i) + "");
        }
        return sum;
    }

    private int change(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
