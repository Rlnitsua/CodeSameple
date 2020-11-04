package rlnitsua.string;


public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] resChars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            resChars[indices[i]] = s.charAt(i);
        }
        return String.valueOf(resChars);
    }
}
