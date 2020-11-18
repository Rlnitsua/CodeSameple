package rlnitsua.string;

public class ReverseStringInAStringII {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int l = 0;
        int r;
        int index = 0;

        while (index < s.length) {
            if (s[index] == ' ' || index == s.length - 1) {
                r = (s[index] == ' ') ? index - 1 : index;
                reverse(s, l, r);
                l = r + 2;
            }
            index++;
        }
    }

    private void reverse(char[] s, int l, int r) {
        for (int i = l; i <= (r + l - 1) / 2; i++) {
            char temp = s[i];
            s[i] = s[l + r - i];
            s[l + r - i] = temp;
        }
    }
}
