package rlnitsua.string;

public class RotateString {
    public boolean rotateString(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        return (b + b).contains(a);
    }
}
