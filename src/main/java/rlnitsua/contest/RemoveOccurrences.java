package rlnitsua.contest;

public class RemoveOccurrences {
    public String removeOccurrences(String s, String part) {
        int start = s.indexOf(part);
        if (start == -1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = start + part.length(); i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return removeOccurrences(sb.toString(), part);
    }
}
